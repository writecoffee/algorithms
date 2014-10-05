import java.util.ArrayList;
import java.util.List;

/**
 * Given a n,m which means the row and column of the 2D matrix and an array of
 * pair A( size k). Originally, the 2D matrix is all 0 which means there is only
 * sea in the matrix. The list pair has k operator and each operator has two
 * integer A[i].x, A[i].y means that you can change the grid
 * matrix[A[i].x][A[i].y] from sea to island. Return how many island are there
 * in the matrix after each operator.
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)].
 *
 * return [1,1,2,2].
 *
 * Note
 *
 * 0 is represented as the sea, 1 is represented as the island. If two 1 is
 * adjacent, we consider them in the same island. We only consider
 * up/down/left/right adjacent.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/number-of-islands-ii/}
 *
 */
public class uf_count_islands_filling_sea_S2
{
    class Point
    {
        int x;
        int y;

        Point()
        {
            x = 0;
            y = 0;
        }

        Point(int a, int b)
        {
            x = a;
            y = b;
        }
    }

    public List<Integer> numIslands2(int n, int m, Point[] operators)
    {
        List<Integer> result = new ArrayList<>();
        Point[][] leaders = new Point[n][m];
        int lastResult = 0;

        if (operators == null) {
            return result;
        }

        for (Point p : operators) {
            Point l1 = safeFind(p, leaders);
            int local = 1;

            for (Point neighbor : getNeighbor(p, leaders)) {
                Point l2 = safeFind(neighbor, leaders);

                if (l2 != l1) {
                    local--;
                    leaders[l2.x][l2.y] = l1;
                }
            }

            lastResult += local;
            result.add(lastResult);
        }

        return result;
    }

    private List<Point> getNeighbor(Point p, Point[][] leaders)
    {
        List<Point> result = new ArrayList<>();

        int x = p.x,
            y = p.y,
            n = leaders.length,
            m = leaders[0].length;

        if (x > 0 && leaders[x - 1][y] != null) {
            result.add(leaders[x - 1][y]);
        }

        if (x < n - 1 && leaders[x + 1][y] != null) {
            result.add(leaders[x + 1][y]);
        }

        if (y > 0 && leaders[x][y - 1] != null) {
            result.add(leaders[x][y - 1]);
        }

        if (y < m - 1 && leaders[x][y + 1] != null) {
            result.add(leaders[x][y + 1]);
        }

        return result;
    }

    private Point safeFind(Point c, Point[][] leaders)
    {
        if (leaders[c.x][c.y] == null) {
            leaders[c.x][c.y] = c;
            return c;
        }

        Point result = c;

        while (result != leaders[result.x][result.y]) {
            result = leaders[result.x][result.y];
        }

        /*
         * Shorten the path to reach leader.
         */
        while (c != leaders[c.x][c.y]) {
            Point t = leaders[c.x][c.y];
            leaders[c.x][c.y] = result;
            c = t;
        }

        return result;
    }
}

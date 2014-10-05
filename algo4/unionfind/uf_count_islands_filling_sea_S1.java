import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class uf_count_islands_filling_sea_S1
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

    @SuppressWarnings("unchecked")
    public List<Integer> numIslands2(int n, int m, Point[] operators)
    {
        List<Integer> result = new ArrayList<>();
        Set<?>[][] leaders = new Set<?>[n][m];
        int lastResult = 0;

        if (operators == null) {
            return result;
        }

        for (Point p : operators) {
            Set<Point> l1 = safeFind(p, (Set<Point>[][]) leaders);
            int local = 1,
                previousSize = 1;

            for (Set<Point> neighbor : getNeighbor(p, (Set<Point>[][]) leaders)) {
                Set<Point> united = safeUnion(l1, neighbor, leaders);

                /* Avoid duplicate deducting the unions. */
                if (united.size() != previousSize) {
                    local -= 1;
                    previousSize = united.size();
                }

                l1 = united;
            }

            lastResult += local;
            result.add(lastResult);
        }

        return result;
    }

    private Set<Point> safeUnion(Set<Point> set1, Set<Point> set2, Set<?>[][] leaders)
    {
        Set<Point> bigger = set1.size() > set2.size() ? set1 : set2,
                   smaller = set1.size() > set2.size() ? set2 : set1;

        /* Take too much time in this operation. */
        bigger.addAll(smaller);
        for (Point p : smaller) {
            leaders[p.x][p.y] = bigger;
        }

        return bigger;
    }

    private List<Set<Point>> getNeighbor(Point p, Set<Point>[][] leaders)
    {
        List<Set<Point>> result = new ArrayList<>();

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

    private Set<Point> safeFind(Point c, Set<Point>[][] leaders)
    {
        if (leaders[c.x][c.y] == null) {
            leaders[c.x][c.y] = new HashSet<>(Arrays.asList(new Point[] { c }));
        }

        return leaders[c.x][c.y];
    }
}

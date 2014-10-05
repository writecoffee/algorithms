import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a matrix to represent the height of a terrace. Calculate the maximum water
 * that could be trapped in the terrace.
 *
 * For example:
 *
 * (1) Given terrace:
 *
 *     [ 1 3 4 7 ]
 *     [ 4 1 2 4 ]
 *     [ 3 2 4 7 ]
 *     [ 5 6 4 9 ]
 *
 *     The maximum number of water that could be trapped is 4.
 *
 * (2) Given terrace:
 *
 *     [ 1 7 1 1 ]
 *     [ 4 3 3 4 ]
 *     [ 7 7 7 7 ]
 *
 *     The maximum number of water that could be trapped is 0.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/trapping-rain-water-ii/}
 * [Difficulty] - Hard
 *
 */
public class hp_trapping_rain_water_3d
{
    private class Cell implements Comparable<Cell>
    {
        private int x;
        private int y;
        private int h;

        public Cell(int _x, int _y, int _h)
        {
            x = _x;
            y = _y;
            h = _h;
        }

        @Override
        public int compareTo(Cell o)
        {
            return h - o.h;
        }
    }

    /**
     * "The capacity of a bucket is determined by its shortest plank."
     *
     *
     */
    public int trapRainWater(int[][] heights)
    {
        int m = heights.length,
            n = heights[0].length;

        int water = 0;

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();

        fillSurrouding(pq, heights, m, n, visited);

        while (!pq.isEmpty()) {
            Cell c = pq.poll();

            for (Cell neighbor : getValidNeighbor(c, visited, heights, m, n)) {
                int hDiff = Math.max(0, c.h - neighbor.h);
                neighbor.h = neighbor.h + hDiff;
                water += hDiff;
                pq.add(neighbor);
                visited[neighbor.y][neighbor.x] = true;
            }
        }

        return water;
    }

    private static int[][] direction = new int[][] { { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 0 } };

    private List<Cell> getValidNeighbor(Cell c, boolean[][] visited, int[][] heights, int m, int n)
    {
        List<Cell> result = new ArrayList<>();

        int x = c.x, y = c.y;

        for (int[] dir : direction) {
            int nx = x + dir[0],
                ny = y + dir[1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[ny][nx]) {
                continue;
            }

            result.add(new Cell(nx, ny, heights[ny][nx]));
        }

        return result;
    }

    private void fillSurrouding(PriorityQueue<Cell> pq, int[][] heights, int m, int n, boolean[][] visited)
    {
        for (int i = 0; i < n; i++) {
            pq.add(new Cell(i, 0, heights[0][i]));
            pq.add(new Cell(i, m - 1, heights[m - 1][i]));
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }

        for (int i = 0; i < m; i++) {
            pq.add(new Cell(0, i, heights[i][0]));
            pq.add(new Cell(n - 1, i, heights[i][n - 1]));
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
    }
}

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
 */
public class trapping_rain_water_3d {
    private class Cell implements Comparable<Cell> {
        private int x;
        private int y;
        private int h;

        public Cell(int _x, int _y, int _h) {
            x = _x;
            y = _y;
            h = _h;
        }

        @Override
        public int compareTo(Cell o) {
            return h - o.h;
        }
    }

    private int check(int[][] heights, boolean[][] visited, int x, int y, int threshold, int m, int n, PriorityQueue<Cell> pq) {
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
            return 0;
        }

        int count = 0;

        if (heights[x][y] < threshold) {
            count += threshold - heights[x][y];
        }

        visited[x][y] = true;
        pq.add(new Cell(x, y, Math.max(threshold, heights[x][y])));
        return count;
    }

    /**
     * The first attempting solution could be applying the 2-d solution to each column and row
     * then pick the minimum water that could be trapped for row i and column j.
     * 
     * But this does work for example (2) since we have to take care of the "leaking" cases.
     * 
     * The time complexity in the following solution is O(n^2 log n).
     * 
     */
    public int trapWater(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>();
        int count = 0;

        for (int i = 0; i < m; i++) {
            visited[i][0] = visited[i][n - 1] = true;
            pq.add(new Cell(i, 0, matrix[i][0]));
            pq.add(new Cell(i, n - 1, matrix[i][n - 1]));
        }

        for (int j = 1; j < n - 1; j++) {
            visited[0][j] = visited[m - 1][j] = true;
            pq.add(new Cell(0, j, matrix[0][j]));
            pq.add(new Cell(m - 1, j, matrix[m - 1][j]));
        }

        while (!pq.isEmpty()) {
            Cell c = pq.poll();
            count += check(matrix, visited, c.x - 1, c.y, c.h, m, n, pq);
            count += check(matrix, visited, c.x + 1, c.y, c.h, m, n, pq);
            count += check(matrix, visited, c.x, c.y - 1, c.h, m, n, pq);
            count += check(matrix, visited, c.x, c.y + 1, c.h, m, n, pq);
        }

        return count;
    }
}
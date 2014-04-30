package matrix;

public class maximum_sub_matrix_sum {
    /**
     * The brute-force solution is that we need to enumerate through all possible starting
     * position (i, j) and all possible width, height of that window to compute the maximum
     * sum. That is O(m * n * m * n) time complexity.
     * 
     * This problem can be tackled by looking at the one-dimension problem. After applying
     * the one-dimension view, we can know the starting column and the width of that window.
     * 
     * So we just need to enumerate all possible start row and height of the window.
     */
    public int maxRectSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int gMax = 0;

        for (int i = 0; i < m; ++i) {
            int[] t = new int[n];

            for (int h = i; h < m; ++h) {
                for (int j = 0; j < n; ++j) {
                    t[j] += matrix[h][j];
                }

                gMax = Math.max(gMax, maxArraySum(t));
            }
        }

        return gMax;
    }

    private int maxArraySum(int[] t) {
        int lMax = t[0], gMax = t[0];
        for (int i = 1; i < t.length; ++i) {
            if (lMax <= 0) {
                lMax = 0;
            }

            lMax += t[i];
            gMax = Math.max(gMax, lMax);
        }

        return gMax;
    }
}
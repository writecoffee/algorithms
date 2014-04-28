public class maximum_sub_matrix_sum {
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
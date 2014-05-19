package basic;

public class dp_non_consecutive_color_housing_printing_with_minimum_cost {
    /**
     * matrix[i][j]: the cost for printing house i with color j.
     *
     */
    public static int calculate(int[][] matrix) {
        assert matrix.length > 0 && matrix[0].length > 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int[] l2r = new int[n + 2];
        int[] r2l = new int[n + 2];

        l2r[0] = Integer.MAX_VALUE;
        l2r[n + 1] = Integer.MAX_VALUE;
        r2l[0] = Integer.MAX_VALUE;
        r2l[n + 1] = Integer.MAX_VALUE;

        for (int j = 1; j <= n; ++j) {
            l2r[j] = Math.min(matrix[0][j - 1], l2r[j - 1]);
        }

        for (int j = n; j >= 1; --j) {
            r2l[j] = Math.min(matrix[0][j - 1], r2l[j + 1]);
        }

        for (int i = 1; i < m; ++i) {
            int[] c = new int[n + 2];
            c[0] = Integer.MAX_VALUE;
            c[n + 1]  = Integer.MAX_VALUE;

            for (int j = 1; j <= n; ++j) {
                c[j] = Math.min(l2r[j - 1], r2l[j + 1]) + matrix[i][j - 1];
            }

            l2r[0] = Integer.MAX_VALUE;
            for (int j = 1; j <= n; ++j) {
                l2r[j] = Math.min(c[j], l2r[j - 1]);
            }

            r2l[n + 1] = Integer.MAX_VALUE;
            for (int j = n; j >= 1; --j) {
                r2l[j] = Math.min(c[j], r2l[j + 1]);
            }
        }

        return l2r[n];
    }

    public static void main(String[] args) {
        int[][] A = new int[][] {
                        { 1, 5, 3, 9, 2 },
                        { 2, 3, 4, 5, 7 },
                        { 2, 3, 4, 9, 5 } };

        System.out.println(calculate(A));
    }
}
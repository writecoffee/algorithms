package matrix;

public class set_matrix_zeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rowBlock = new boolean[m];
        boolean[] colBlock = new boolean[n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    rowBlock[i] = true;
                    colBlock[j] = true;
                }
            }
        }

        for (int i = 0; i < m; ++i) {
            if (rowBlock[i]) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (colBlock[i]) {
                for (int j = 0; j < m; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    public void setZeroesOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean fc = detectFirstCol(matrix, m, n);
        boolean fr = detectFirstRow(matrix, m, n);

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (fc) {
            for (int i = 0; i < m; ++i) {
                matrix[i][0] = 0;
            }
        }

        if (fr) {
            for (int i = 0; i < n; ++i) {
                matrix[0][i] = 0;
            }
        }
    }

    private boolean detectFirstRow(int[][] matrix, int m, int n) {
        boolean f = false;

        for (int i = 0; i < n; ++i) {
            if (matrix[0][i] == 0) {
                f = true;
            }
        }

        return f;
    }

    private boolean detectFirstCol(int[][] matrix, int m, int n) {
        boolean f = false;

        for (int i = 0; i < m; ++i) {
            if (matrix[i][0] == 0) {
                f = true;
            }
        }

        return f;
    }
}
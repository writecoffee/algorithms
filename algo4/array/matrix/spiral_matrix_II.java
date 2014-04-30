package matrix;

public class spiral_matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];

        int depth = n / 2;
        int accumulator = 1;
        for (int i = 0; i < depth; i++) {
            int width = n - 1 - i;

            for (int j = i; j < width; j++) {
                result[i][j] = accumulator++;
            }

            for (int j = i; j < width; j++) {
                result[j][n - 1 - i] = accumulator++;
            }

            for (int j = i; j < width; j++) {
                result[n - 1 - i][n - 1 - j] = accumulator++;
            }

            for (int j = i; j < width; j++) {
                result[n - 1 - j][i] = accumulator++;
            }
        }

        if (n % 2 == 1) {
            result[depth][depth] = accumulator;
        }

        return result;
    }

    public int[][] generateMatrixOptional(int n) {
        int[][] result = new int[n][n];
        int iMin = 0, iMax = n - 1;
        int jMin = 0, jMax = n - 1;
        int v = 1;

        while (true) {
            for (int j = jMin; j <= jMax; ++j) {
                result[iMin][j] = v++;
            }

            if (++iMin > iMax) {
                break;
            }

            for (int i = iMin; i <= iMax; ++i) {
                result[i][jMax] = v++;
            }

            if (--jMax < jMin) {
                break;
            }

            for (int j = jMax; j >= jMin; --j) {
                result[iMax][j] = v++;
            }

            if (--iMax < iMax) {
                break;
            }

            for (int i = iMax; i >= iMin; --i) {
                result[i][jMin] = v++;
            }

            if (++jMin > jMax) {
                break;
            }
        }

        return result;
    }
}
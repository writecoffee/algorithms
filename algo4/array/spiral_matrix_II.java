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
}
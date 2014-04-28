public class rotate_image {
    public void rotate(int[][] matrix) {
        int depth = matrix.length / 2;

        for (int i = 0; i < depth; i++) {
            int width = matrix.length - 1 - i;

            for (int j = i; j < width; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = temp;
            }
        }
    }
}
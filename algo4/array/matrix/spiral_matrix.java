import java.util.ArrayList;

public class spiral_matrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return result;
        }

        int i = 0;
        while (result.size() < matrix.length * matrix[0].length) {
            int width = matrix[0].length - 1 - i;
            int height = matrix.length - 1 - i;

            if (i == height) {
                for (int j = i; j < width + 1; ++j) {
                    result.add(matrix[i][j]);
                }

                break;
            }

            if (i == width) {
                for (int j = i; j < height + 1; ++j) {
                    result.add(matrix[j][i]);
                }

                break;
            }

            for (int j = i; j < width; j++) {
                result.add(matrix[i][j]);
            }

            for (int j = i; j < height; j++) {
                result.add(matrix[j][matrix[0].length - 1 - i]);
            }

            for (int j = i; j < width; j++) {
                result.add(matrix[matrix.length - 1 - i][matrix[0].length - 1 - j]);
            }

            for (int j = i; j < height; j++) {
                result.add(matrix[matrix.length - 1 - j][i]);
            }

            i++;
        }

        return result;
    }
}
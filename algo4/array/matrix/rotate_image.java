package matrix;

public class rotate_image
{
    public void rotate(int[][] matrix)
    {
        int n = matrix.length;
        int d = n / 2;

        for (int i = 0; i < d; ++i) {
            for (int j = i; j < n - i - 1; ++j) {
                int t = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = t;
            }
        }
    }
}

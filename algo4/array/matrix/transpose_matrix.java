package matrix;

import java.util.List;

public class transpose_matrix
{
    public int[][] transpose(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] output = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                output[j][i] = matrix[i][j];
            }
        }

        return output;
    }

    public String conjunct(List<String> input, int lineLimit)
    {
        int n = input.size();
        StringBuilder sb = new StringBuilder();

        if (n == 0) {
            return "";
        }

        sb.append(input.get(0));

        for (int i = 1; i < n - 1; i++) {
            sb.append(", ");
            sb.append(input.get(i));
        }

        sb.append(" and ");
        sb.append(input.get(n - 1));
        return sb.toString();
    }
}

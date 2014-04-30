package matrix;

import java.util.ArrayList;

public class spiral_matrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int imin = 0, imax = m - 1;
        int jmin = 0, jmax = n - 1;

        while (true) {
            for (int j = jmin; j <= jmax; ++j) {
                result.add(matrix[imin][j]);
            }

            if (++imin > imax) {
                break;
            }

            for (int i = imin; i <= imax; ++i) {
                result.add(matrix[i][jmax]);
            }

            if (jmin > --jmax) {
                break;
            }

            for (int j = jmax; j >= jmin; --j) {
                result.add(matrix[imax][j]);
            }

            if (imin > --imax) {
                break;
            }

            for (int i = imax; i >= imin; --i) {
                result.add(matrix[i][jmin]);
            }

            if (++jmin > jmax) {
                break;
            }
        }

        return result;
    }
}
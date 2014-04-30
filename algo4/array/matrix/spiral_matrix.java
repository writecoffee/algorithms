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
        int iMin = 0, iMax = m - 1;
        int jMin = 0, jMax = n - 1;

        while (true) {
            for (int j = jMin; j <= jMax; ++j) {
                result.add(matrix[iMin][j]);
            }

            if (++iMin > iMax) {
                break;
            }

            for (int i = iMin; i <= iMax; ++i) {
                result.add(matrix[i][jMax]);
            }

            if (--jMax < jMin) {
                break;
            }

            for (int j = jMax; j >= jMin; --j) {
                result.add(matrix[iMax][j]);
            }

            if (--iMax < iMin) {
                break;
            }

            for (int i = iMax; i >= iMin; --i) {
                result.add(matrix[i][jMin]);
            }

            if (++jMin > jMax) {
                break;
            }
        }

        return result;
    }
}
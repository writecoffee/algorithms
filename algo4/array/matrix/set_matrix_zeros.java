
public class set_matrix_zeros {

    public static void setZeroes(int[][] matrix) {
        int M = matrix[0].length;
        int N = matrix.length;

        int[] rowRecord = new int[N];
        int[] colRecord = new int[M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 0) {
                    rowRecord[i] = 1;
                    colRecord[i] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (rowRecord[i] == 1) {
                    matrix[i][j] = 0;
                } else if (colRecord[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public static void setZeroesImprove(int[][] matrix) {
        boolean isZeroableFirstRow = false;
        boolean isZeroableFirstCol = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                isZeroableFirstRow = true;
                break;
            }
        }

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isZeroableFirstCol = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++)
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }

        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++)
                    matrix[i][j] = 0;
            }
        }

        for (int i = 1; i < rows; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < cols; j++)
                    matrix[i][j] = 0;
            }
        }

        if (isZeroableFirstRow) {
            for (int i = 0; i < cols; i++)
                matrix[0][i] = 0;
        }

        if (isZeroableFirstCol) {
            for (int i = 0; i < rows; i++)
                matrix[i][0] = 0;
        }
    }
    
    public static int[][] test = {{1, 0}};
    
    public static void main(String[] args) {
        setZeroes(test);
    }
}
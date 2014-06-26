package basic;

/**
 * A number in a matrix is an equilibrium number if the sum for all columns to its left
 * equals to the sum for all columns to its right, and the sum for all its upper rows equals
 * to the sum for all its bottom rows.
 * 
 * Your task is to count how many this kind of numbers exist in the matrix.
 * 
 * Solve this using O(m * n) time complexity and O(n + m) space complexity.
 * 
 * [Difficulty] - Medium
 * [Source]     - twitter quiz
 *
 */
public class dp_count_equilibrium_numbers_in_matrix {
    /**
     * Let i, j be 0-based indices.
     * Let R(i, j) denote whether the number[i][j] is an equilibrium point.
     * Let dpRow(i) denote the sum for all numbers from row 0 to row i, inclusively.
     * Let dpCol(j) denote the sum for all numbers from column 0 to column j, inclusively.
     * 
     * R(i, j) holds only if dpRow(i - 1) == dpRow(n) - dpRow(i) and
     *                       dpCol(j - 1) == dpCol(m) - dpCol(j)
     * 
     */
    public int solution(int[][] A) {
        if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
            return 0;
        }

        int n = A.length, m = A[0].length;
        int[] rows = new int[n + 2], cols = new int[m + 2];
        int[] dpRow = new int[n + 2], dpCol = new int[m + 2];
        int count = 0;

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                cols[j] += A[i - 1][j - 1];
                rows[i] += A[i - 1][j - 1];
            }
        }

        for (int i = 1; i < n + 2; ++i) {
            dpRow[i] = rows[i] + dpRow[i - 1];
        }

        for (int j = 1; j < m + 2; ++j) {
            dpCol[j] = cols[j] + dpCol[j - 1];
        }

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                if (dpRow[i - 1] == dpRow[n + 1] - dpRow[i] && dpCol[j - 1] == dpCol[m + 1] - dpCol[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
public class search_in_a_row_col_sorted_2d_matrix {
    /**
     * This run in O(m + n) time.
     * 
     */
    public boolean SearchInRowColSortedMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            int t = matrix[i][j];

            if (t == target) {
                return true;
            } else if (t < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
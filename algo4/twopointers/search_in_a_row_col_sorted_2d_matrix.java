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
            int lastElement = matrix[i][j];

            if (lastElement == target) {
                return true;
            } else if (lastElement < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
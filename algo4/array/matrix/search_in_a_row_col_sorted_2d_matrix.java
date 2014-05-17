package matrix;

public class search_in_a_row_col_sorted_2d_matrix {
    /**
     * There is a n * m 2-dimension matrix, each row, each column is in ascending order. Determine
     * whether the matrix contains the target number.
     * 
     * The key observation here is that starting off from the upper-right corner, if that value
     * is smaller than target, we can eliminate all elements above the current row. If that value
     * is bigger than target, we can eliminate all elements on the right of the current column.
     * 
     * This runs in O(m + n) time.
     * 
     * http://www.itint5.com/oj/#38
     * 
     */
    public boolean SearchInRowColSortedMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0, j = n - 1;

        while (i < m && j >= 0) {
            int val = matrix[i][j];

            if (val == target) {
                return true;
            } else if (val < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
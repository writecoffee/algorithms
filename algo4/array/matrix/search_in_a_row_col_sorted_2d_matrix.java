package matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 *
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.itint5.com/oj/#38}
 *                {@linkplain https://leetcode.com/problems/search-a-2d-matrix-ii/}
 *
 */
public class search_in_a_row_col_sorted_2d_matrix
{
    /**
     * There is a n * m 2-dimension matrix, each row, each column is in
     * ascending order. Determine whether the matrix contains the target number.
     *
     * The key observation here is that starting off from the upper-right
     * corner, if that value is smaller than target, we can eliminate all
     * elements above the current row. If that value is bigger than target, we
     * can eliminate all elements on the right of the current column.
     *
     * This runs in O(m + n) time.
     *
     *
     */
    public boolean searchMatrix(int[][] matrix, int target)
    {
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

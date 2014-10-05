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
public class bs_search_a_row_col_sorted_2d_matrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        int m = matrix.length,
            n = matrix[0].length;

        int i = 0,
            j = n - 1;

        while (i < m && j >= 0) {
            int indexCol = binarySearchOnRow(matrix[i], 0, j, target);

            if (matrix[i][Math.min(indexCol, n - 1)] == target) {
                return true;
            }

            int indexRow = binarySearchOnColumn(matrix, Math.min(indexCol, n - 1), i + 1, m - 1, target);

            if (matrix[Math.min(indexRow, m - 1)][Math.min(indexCol, n - 1)] == target) {
                return true;
            }

            i = indexRow;
            j = indexCol - 1;
        }

        return false;
    }

    private int binarySearchOnRow(int[] row, int start, int end, int target)
    {
        int i = start,
            j = end;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (row[mid] == target) {
                return mid;
            } else if (row[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }

    private int binarySearchOnColumn(int[][] matrix, int column, int start, int end, int target)
    {
        int i = start,
            j = end;

        while (i <= j) {
            int mid = (i + j) / 2;

            if (matrix[mid][column] == target) {
                return mid;
            } else if (matrix[mid][column] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return i;
    }
}

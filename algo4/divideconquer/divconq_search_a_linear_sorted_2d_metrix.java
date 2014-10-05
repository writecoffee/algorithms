/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
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
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/search-a-2d-matrix-ii/}
 *
 */
public class divconq_search_a_linear_sorted_2d_metrix
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        return divConq(matrix, 0, 0, matrix[0].length - 1, matrix.length - 1, target);
    }

    private boolean divConq(int[][] matrix, int x1, int y1, int x2, int y2, int target)
    {
        if (x1 > x2 || y1 > y2) {
            return false;
        } else if (x1 == x2 && y2 == y1) {
            return matrix[y1][x1] == target;
        }

        int mx = (x1 + x2) / 2,
            my = (y1 + y2) / 2,
            midVal = matrix[my][mx];

        if (midVal == target) {
            return true;
        } else if (midVal > target) {
            return divConq(matrix, x1, y1, mx, my, target)
                || divConq(matrix, mx + 1, y1, x2, my - 1, target)
                || divConq(matrix, x1, my + 1, mx - 1, y2, target);
        } else {
            return divConq(matrix, mx + 1, y1, x2, my, target)
                || divConq(matrix, x1, my + 1, mx, y2, target)
                || divConq(matrix, mx + 1, my + 1, x2, y2, target);
        }
    }
}

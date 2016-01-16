package presum;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer matrix, find a submatrix where the sum of numbers is zero.
 * Your code should return the coordinate of the left-up and right-down number.
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given matrix
 *
 * [
 *  [1 ,5 ,7],
 *  [3 ,7 ,-8],
 *  [4 ,-8 ,9],
 * ]
 *
 * return [(1,1), (2,2)]
 *
 * Challenge: O(n^3) time.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/submatrix-sum/}
 * [Difficulty] - Medium
 *
 */
public class arr_ps_submatrix_sum
{
    public int[][] submatrixSum(int[][] matrix)
    {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] indvColumnSum = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                indvColumnSum[i + 1][j + 1] += indvColumnSum[i][j + 1] + matrix[i][j];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                int[] subColumnSum = new int[n + 1];

                for (int k = 1; k <= n; k++) {
                    subColumnSum[k] += subColumnSum[k - 1] + indvColumnSum[j][k] - indvColumnSum[i - 1][k];
                }

                Map<Integer, Integer> h = new HashMap<>();
                h.put(0, -1);
                for (int k = 1; k <= n; k++) {
                    int val = subColumnSum[k];

                    if (h.containsKey(val)) {
                        return new int[][] { { i - 1, h.get(val) + 1 }, { j - 1, k - 1 } };
                    }

                    h.put(val, k - 1);
                }
            }
        }

        return new int[][] { { -1, -1 }, { -1, -1 } };
    }
}

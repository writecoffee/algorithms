package gmin;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * http://oj.leetcode.com/problems/minimum-path-sum/
 * 
 */
public class dp_minimum_path_sum_in_grid {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int j = 1; j < n; ++j) {
            dp[j] = grid[0][j] + dp[j - 1];
        }

        for (int i = 1; i < m; ++i) {
            dp[0] = grid[i][0] + dp[0];

            for (int j = 1; j < n; ++j) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }

        return dp[n - 1];
    }
}
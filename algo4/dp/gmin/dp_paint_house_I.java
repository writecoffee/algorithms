package gmin;

/**
 * There are a row of n houses, each house can be painted with one of the three
 * colors: red, blue or green. The cost of painting each house with a certain
 * color is different. You have to paint all the houses such that no two
 * adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x
 * 3 cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color red; costs[1][2] is the cost of painting house 1 with color green, and
 * so on... Find the minimum cost to paint all houses.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/paint-house/}
 * [Difficulty] - Easy
 *
 */
public class dp_paint_house_I
{
    public int minCost(int[][] costs)
    {
        int n = costs.length;

        // 3 * 2^(n - 1)
        // dp_red[i] = min{ dp_blue[i - 1], dp_green[i - 1] } + costs[i][RED];
        // dp_red[0] = cost[0][RED];
        // min { dp_red[n - 1], dp_blue[n - 1], dp_green[n - 1] };
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[] { costs[0][0], costs[0][1], costs[0][2] };
        for (int i = 1; i < n; i++) {
            int col0 = Math.min(dp[1], dp[2]) + costs[i][0];
            int col1 = Math.min(dp[0], dp[2]) + costs[i][1];
            int col2 = Math.min(dp[0], dp[1]) + costs[i][2];
            dp = new int[] { col0, col1, col2 };
        }

        return Math.min(Math.min(dp[0], dp[1]), dp[2]);
    }
}

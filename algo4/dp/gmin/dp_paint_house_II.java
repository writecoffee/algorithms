package gmin;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are a row of n houses, each house can be painted with one of the k
 * colors. The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the
 * same color.
 * 
 * The cost of painting each house with a certain color is represented by a n x
 * k cost matrix. For example, costs[0][0] is the cost of painting house 0 with
 * color 0; costs[1][2] is the cost of painting house 1 with color 2, and so
 * on... Find the minimum cost to paint all houses.
 * 
 * Note:
 * 
 * All costs are positive integers.
 * 
 * Follow up:
 * 
 * Could you solve it in O(nk) runtime?
 * 
 * [Source]     - {@linkplain https://leetcode.com/problems/paint-house-ii/}
 * [Difficulty] - Medium
 *
 */
public class dp_paint_house_II
{
    public int minCostII(int[][] costs)
    {
        int n = costs.length;

        if (n == 0) {
            return 0;
        }

        int k = costs[0].length;
        int[][] dp = new int[n][k];

        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = getMin(dp[i - 1], j) + costs[i][j];
            }
        }

        return getMin(dp[n - 1], -1);
    }

    private int getMin(int[] costs, int except)
    {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < costs.length; i++) {
            if (i == except) {
                continue;
            }

            result = Math.min(result, costs[i]);
        }

        return result;
    }

    public static int minCostIIOnk(int[][] costs)
    {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;
        int[] dp = new int[k];
        Queue<Integer> pq = new PriorityQueue<>();
        int min1 = -1, min2 = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int previous = dp[j] == min1 ? min2 : min1;
                dp[j] = previous + costs[i][j];
                pq.offer(dp[j]);
            }

            min1 = pq.poll();
            min2 = pq.poll();
            pq.clear();
        }

        return min1;
    }
}

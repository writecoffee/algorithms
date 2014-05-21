package gmin;

/**
 * Bilbo has a long journey ahead of him and wants to stay in comfortable hotels along his route
 * each night, but can only walk k miles in a day. Fortunately, he has a guidebook charting the
 * locations of all the hotels along his route. (Bilbo already knows which route he is taking; he
 * only has to choose where along his route to stay each night.)
 * 
 * Bilbo realizes that, actually, the different hotels cost different amounts, and what he actually
 * wants to do is minimize the total cost of his journey.
 * 
 */
public class dp_minimum_hotel_cost_along_journey {
    public int minCost(int[] distance, int[] cost, int k) {
        int n = distance.length;
        int[] dp = new int[n];
        dp[0] = cost[0];

        for (int i = 1; i < n; ++i) {
            dp[i] = dp[i - 1] + cost[i];

            for (int j = i - 2; j >= 0 && distance[i] - distance[j] <= k; --j) {
                dp[i] = Math.min(dp[i], dp[j] + cost[i]);
            }
        }

        return dp[n - 1];
    }
}
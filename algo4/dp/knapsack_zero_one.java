public class knapsack_zero_one {
    public int getMax(int capacity, int[] weights, int[] values) {
        int m = weights.length;
        int[][] dp = new int[m + 1][capacity + 1];

        for (int i = 0; i <= capacity; ++i) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; ++i) {
            for (int w = 1; w <= capacity; ++w) {
                if (w - weights[i - 1] >= 0) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[m][capacity];
    }
}
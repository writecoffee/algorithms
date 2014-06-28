package basic;

/**
 * We have n objects and a knapsack. The i-th object has positive weight w[i] and positive value
 * v[i]. The knapsack capacity is C. We wish to select a set of objects to put in the knapsack so
 * that the total values is maximum and without breaking the knapsack.
 * 
 * [Difficulty] - Medium
 * [Source]     - Classical problem
 * 
 */
public class dp_knapsack_maximum_value {
    public int getMax(int capacity, int[] w, int[] v) {
        int n = w.length;
        int[][] dp = new int[capacity][n + 1];

        for (int i = 0; i < capacity; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (i - w[j - 1] < 0) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - w[j - 1]][j] + v[j - 1]);
                }
            }
        }

        return dp[capacity - 1][n];
    }
}
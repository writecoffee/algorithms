package gmin;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm } valued coins, what is the minimum number
 * of coins required for value N.
 * 
 * For example, for N = 4 and S = {1,2,3}, the minimum number is 2.
 * 
 * In the US (and most other) coin systems, a greedy algorithm of picking the largest
 * denomination of coin which is not greater than the remaining amount to be made will
 * always produce the optimal result. This is not automatically the case, though: if
 * the coin denominations were 1, 3 and 4, then to make 6, the greedy algorithm would
 * choose three coins (4,1,1) whereas the optimal solution is two coins (3,3).
 *
 * [Difficulty] - Medium
 * [Source]     - snapchat interview
 * 
 */
public class dp_minimum_coin_changes {
    public int count(int[] denomination, int value) {
        int n = denomination.length;
        int[][] dp = new int[value + 1][n + 1];

        for (int i = 1; i <= value; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (denomination[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else if (dp[i][j - 1] > 0) {
                    dp[i][j] = Math.min(dp[i][j - 1], dp[i - denomination[j - 1]][j] + 1);
                } else {
                    dp[i][j] = dp[i - denomination[j - 1]][j] + 1;
                }
            }
        }

        return dp[value][n];
    }
}
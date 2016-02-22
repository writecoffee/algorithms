package memorization_search;

import java.util.Arrays;

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
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that
 * amount. If that amount of money cannot be made up by any combination of the coins,
 * return -1.
 *
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 *
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 *
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * [Difficulty] - Medium
 * [Source]     - snapchat interview
 *                {@linkplain https://leetcode.com/problems/coin-change/}
 *
 */
public class dp_ms_coin_changes
{
    public int coinChange(int[] coins, int value)
    {
        int n = coins.length;
        int[] dp = new int[value + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 1; i < value + 1; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        if (dp[value] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[value];
        }
    }
}

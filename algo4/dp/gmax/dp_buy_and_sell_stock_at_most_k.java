package gmax;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 *
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock-iv/}
 *              - {@linkplain https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/}
 *
 */
public class dp_buy_and_sell_stock_at_most_k
{
    /**
     * MustSell[i][j] = max(MustSell[i - 1][j] + profit, GlobalBest[i - 1][j - 1] + profit)
     * GlobalBest[i][j] = max(GlobalBest[i - 1][j], MustSell[i][j])
     *
     */
    public int maxProfit(int k, int[] prices)
    {
        int n = prices.length;

        if (n == 0) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }

            return profit;
        }

        int[][] mustSell = new int[n][k + 1];
        int[][] globalMax = new int[n][k + 1];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int gain = prices[i] - prices[i - 1];

                mustSell[i][j] = Math.max(mustSell[i - 1][j] + gain,
                                          globalMax[i - 1][j - 1] + gain);

                globalMax[i][j] = Math.max(globalMax[i - 1][j],
                                           mustSell[i][j]);
            }
        }

        return globalMax[n - 1][k];
    }
}

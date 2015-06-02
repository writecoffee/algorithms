package gmax;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/}
 *
 */
public class dp_buy_and_sell_stock_buy_sell_twice
{
    public int maxProfit(int[] prices)
    {
        int n = prices.length;
        int result = 0;

        if (n <= 1) {
            return result;
        }

        int[] l2r = new int[n];
        int[] r2l = new int[n];

        int lMin = prices[0];
        prices[0] = 0;
        for (int i = 1; i < n; ++i) {
            lMin = Math.min(lMin, prices[i]);
            l2r[i] = Math.max(l2r[i - 1], prices[i] - lMin);
        }

        int lMax = prices[n - 1];
        prices[n - 1] = 0;
        for (int i = n - 2; i >= 0; --i) {
            lMax = Math.max(lMax, prices[i]);
            r2l[i] = Math.max(r2l[i + 1], lMax - prices[i]);
        }

        for (int i = 0; i < n - 1; ++i) {
            result = Math.max(result, l2r[i] + r2l[i + 1]);
        }
        result = Math.max(result, l2r[n - 1]);

        return result;
    }
}

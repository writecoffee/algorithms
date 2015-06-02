package gmax;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/best-time-to-buy-and-sell-stock/}
 *
 */
public class dp_buy_and_sell_stock_buy_sell_once
{
    public int maxProfit(int[] prices)
    {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int gMax = 0;

        for (int i = 1; i < n; ++i) {
            minPrice = Math.min(minPrice, prices[i]);
            gMax = Math.max(gMax, prices[i] - minPrice);
        }

        return gMax;
    }
}

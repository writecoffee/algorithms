package gmax;

/**
 * Say you have an array for which the i-th element is the price of a given stock
 * on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (i.e., you must
 * sell the stock before you buy again). After you sell your stock, you cannot
 * buy stock on next day. (i.e., cooldown 1 day) Example:
 *
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/}
 * [Difficulty] - Medium
 *
 */
public class dp_buy_and_sell_stock_with_cooldown
{
    /**
     * Define:
     *
     * profit1[i] = max profit on day i if I sell
     *
     * profit2[i] = max profit on day i if I do nothing How will those profits
     * on day i+1 relate to profits on day i ?
     *
     * 1. profit1[i+1] means I must sell on day i+1, and there are 2 cases:
     *
     *    a. If I just sold on day i, then I have to buy again on day i and sell on
     *       day i+1
     *
     *    b. If I did nothing on day i, then I have to buy today and sell today
     *
     *    Taking both cases into account,
     *    
     *    profit1[i+1] = max(profit1[i] + prices[i+1] - prices[i], profit2[i])
     *
     * 2. profit2[i+1] means I do nothing on day i+1, so it will be
     *
     *    max(profit1[i], profit2[i])
     *
     */
    public int maxProfit(int[] prices)
    {
        int dpSell = 0, dpNotSell = 0;

        for (int i = 1; i < prices.length; i++) {
            int copy = dpSell;
            dpSell = Math.max(dpSell + prices[i] - prices[i - 1], dpNotSell);
            dpNotSell = Math.max(copy, dpNotSell);
        }

        return Math.max(dpSell, dpNotSell);
    }
}

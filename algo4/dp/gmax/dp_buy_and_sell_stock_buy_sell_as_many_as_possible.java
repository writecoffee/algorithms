package gmax;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two
 * transactions.
 *
 * Note: A transaction is a buy & a sell. You may not engage in multiple
 * transactions at the same time (ie, you must sell the stock before you buy
 * again).
 *
 * [Difficulty] - Medium
 * [Source]     - obsolete {@linkplain https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/}
 *
 */
public class dp_buy_and_sell_stock_buy_sell_as_many_as_possible
{
    public int maxProfit(int[] prices)
    {
        int gMax = 0;
        int iMin = -1;
        int n = prices.length;

        for (int i = 0; i < n - 1; ++i) {
            int cP = prices[i];
            int nP = prices[i + 1];

            if (nP > cP && iMin == -1) {
                iMin = i;
            } else if (nP <= cP && iMin >= 0) {
                gMax += (cP - prices[iMin]);
                iMin = -1;
            }
        }

        if (iMin >= 0) {
            gMax += (prices[n - 1] - prices[iMin]);
        }

        return gMax;
    }
}

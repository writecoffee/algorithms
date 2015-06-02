package gmax;

public class dp_buy_and_sell_stock_at_most_k
{
    public int maxProfit(int k, int[] prices)
    {
        if (k > prices.length / 2) {
            int sum = 0;

            for (int i = 1; i < prices.length; i++) {
                sum += Math.max(prices[i] - prices[i - 1], 0);
            }

            return sum;
        }

        if (prices.length < 2) {
            return 0;
        }

        int[][] maxProfit = new int[prices.length][k + 1],
                maxProfitWithTranxOnLastDay = new int[prices.length][k + 1];

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < prices.length; i++) {

                int priceDiff = prices[i] - prices[i - 1],
                    profit = priceDiff > 0 ? priceDiff : 0;

                /*
                 * max profit with new transaction on last day
                 */
                int newTranxOnLastDay = maxProfit[i - 1][j - 1] + profit;

                /*
                 * max profit with continued transaction on last day
                 */
                int continuedTranxOnLastDay = maxProfitWithTranxOnLastDay[i - 1][j] + priceDiff;

                maxProfitWithTranxOnLastDay[i][j] = Math.max(newTranxOnLastDay, continuedTranxOnLastDay);
                maxProfit[i][j] = Math.max(maxProfit[i - 1][j], maxProfitWithTranxOnLastDay[i][j]);
            }
        }

        return maxProfit[prices.length - 1][k];
    }

    public int maxProfitOptimized(int k, int[] prices)
    {
        if (k > prices.length / 2) {
            int sum = 0;

            for (int i = 1; i < prices.length; i++) {
                sum += Math.max(prices[i] - prices[i - 1], 0);
            }

            return sum;
        }

        if (prices.length < 2) {
            return 0;
        }

        int[][] maxProfit = new int[prices.length][2],
                maxProfitWithTransactionOnLastDay = new int[prices.length][2];

        int profit,
            priceDifference,
            maxProfitWithNewTransactionOnLastDay,
            maxProfitWithContinuedTransactionOnLastDay;

        for (int j = 1; j <= k; j++) {
            for (int i = 1; i < prices.length; i++) {
                priceDifference = prices[i] - prices[i - 1];
                profit = priceDifference > 0 ? priceDifference : 0;

                maxProfitWithNewTransactionOnLastDay = maxProfit[i - 1][(j - 1) % 2] + profit;
                maxProfitWithContinuedTransactionOnLastDay = maxProfitWithTransactionOnLastDay[i - 1][(j) % 2] + priceDifference;
                maxProfitWithTransactionOnLastDay[i][j % 2] = Math.max(maxProfitWithNewTransactionOnLastDay, maxProfitWithContinuedTransactionOnLastDay);
                maxProfit[i][j % 2] = Math.max(maxProfit[i - 1][j % 2], maxProfitWithTransactionOnLastDay[i][j % 2]);
            }
        }

        return maxProfit[prices.length - 1][k % 2];
    }
}

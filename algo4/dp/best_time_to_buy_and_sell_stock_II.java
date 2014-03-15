public class best_time_to_buy_and_sell_stock_II {
    public static int maxProfit(int[] prices) {
        int result = 0;
        int iBuy = -1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1] && iBuy == -1) {
                iBuy = i - 1;
            } else if (prices[i] < prices[i - 1] && iBuy != -1) {
                result += prices[i - 1] - prices[iBuy];
                iBuy = -1;
            }
        }

        if (iBuy != -1) {
            result += prices[prices.length - 1] - prices[iBuy];
        }

        return result;
    }

    public static void main(String[] args) {
        maxProfit(new int[] { 1, 4, 3, 2, 4, 5, 7, 9, 2 });
        maxProfit(new int[] { 4, 3, 2, 7 });
    }
}
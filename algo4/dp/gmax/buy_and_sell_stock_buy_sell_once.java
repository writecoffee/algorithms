public class best_time_to_buy_and_sell_stock {
    public static int maxProfit(int[] prices) {
        int iMin = 0;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[iMin]) {
                iMin = i;
            }

            result = Math.max(result, prices[i] - prices[iMin]);
        }

        return result;
    }

    public static void main(String[] args) {
        maxProfit(new int[] { 1, 4, 3, 2 });
        maxProfit(new int[] { 4, 3, 2, 7 });
    }
}
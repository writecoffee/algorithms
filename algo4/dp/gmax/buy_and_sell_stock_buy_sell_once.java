package gmax;

public class buy_and_sell_stock_buy_sell_once {
    public int maxProfit(int[] prices) {
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
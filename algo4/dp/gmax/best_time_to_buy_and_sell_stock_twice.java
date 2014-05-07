package gmax;

public class best_time_to_buy_and_sell_stock_twice {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        int[] l2r = new int[n];
        int[] r2l = new int[n];
        l2r[0] = 0;
        r2l[n - 1] = 0;

        int lMin = prices[0];
        for (int i = 1; i < n; i++) {
            lMin = Math.min(lMin, prices[i]);
            l2r[i] = Math.max(l2r[i - 1], prices[i] - lMin);
        }

        int lMax = prices[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            lMax = Math.max(lMax, prices[i]);
            r2l[i] = Math.max(r2l[i + 1], lMax - prices[i]);
        }

        int result = l2r[n - 1];
        for (int i = 0; i < n - 1; i++) {
            result = Math.max(result, l2r[i] + r2l[i + 1]);
        }

        return result;
    }
}
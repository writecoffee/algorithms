public class best_time_to_buy_and_sell_stock_III {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        if (n <= 1) {
            return 0;
        }

        int[] l2r = new int[n];
        int[] r2l = new int[n];
        l2r[0] = 0;
        r2l[n - 1] = 0;

        int minSoFar = prices[0];
        for (int i = 1; i < n; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            l2r[i] = Math.max(l2r[i - 1], prices[i] - minSoFar);
        }

        int maxSoFar = prices[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            maxSoFar = Math.max(maxSoFar, prices[i]);
            r2l[i] = Math.max(r2l[i + 1], maxSoFar - prices[i]);
        }

        int result = l2r[n - 1];
        for (int i = 0; i < n - 1; i++) {
            result = Math.max(result, l2r[i] + r2l[i + 1]);
        }

        return result;
    }

    public static void main(String[] args) {
        maxProfit(new int[] { 1, 4, 3, 2, 4, 5, 7, 9, 2 });
        maxProfit(new int[] { 4, 3, 2, 7 });
    }
}
package gmax;

public class buy_and_sell_stock_buy_sell_more_than_once {
    public int maxProfit(int[] prices) {
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
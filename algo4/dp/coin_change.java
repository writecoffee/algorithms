public class coin_change {
    public int count(int[] denomination, int value) {
        int m = denomination.length;
        int[][] dp = new int[value + 1][m];

        for (int i = 0; i < m; ++i) {
            dp[0][i] = 1;
        }

        for (int v = 1; v <= value; ++v) {
            for (int j = 0; j < m; ++j) {
                int x = (v - denomination[j] >= 0) ? dp[v - denomination[j]][j] : 0;
                int y = (j >= 1) ? dp[v][j - 1] : 0;

                dp[v][j] = x + y;
            }
        }

        return dp[value][m - 1];
    }
}
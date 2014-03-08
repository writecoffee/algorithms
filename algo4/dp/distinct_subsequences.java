public class distinct_subsequences {
    public static int numDistinct(String S, String T) {
        int m = S.length(), n = T.length();

        if (m < n) {
            return 0;
        }

        int[][] dp = new int[m][n];

        dp[0][0] = S.charAt(0) == T.charAt(0) ? 1 : 0;
        for (int i = 1; i < m; i++) {
            dp[i][0] = S.charAt(i) == T.charAt(0) ? dp[i - 1][0] + 1 : dp[i - 1][0];
        }

        for (int j = 1; j < n; ++j) {
            for (int i = 1; i < m; ++i) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(numDistinct("ccc", "c"));
        System.out.println(numDistinct("ddd", "dd"));
    }
}
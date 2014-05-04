public class palindrome_partitioning_min_cut {
    public int minCut(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        boolean[][] isPalin = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalin[i][i] = true;
            dp[i][i] = 0;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0, j = i + l - 1; i < n - l + 1; i++) {
                if (l == 2) {
                    isPalin[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalin[i][j] = (s.charAt(i) == s.charAt(j)) && isPalin[i + 1][j - 1];
                }

                if (isPalin[i][j]) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + 1);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public int minCutImproved(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i] = n - i;
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i; j < n; ++j) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || isPalin[i + 1][j - 1])) {
                    isPalin[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }

        return dp[0] - 1;
    }

    public int minCutOptimized(String s) {
        int n = s.length();
        boolean[] isPalin = new boolean[n];
        int[] dp = new int[n];
        isPalin[0] = false;

        for (int i = 1; i < n; i++) {
            isPalin[i] = true;
            dp[i] = dp[i - 1] + 1;

            for (int j = 0; j < i; j++) {
                isPalin[j] = (s.charAt(i) == s.charAt(j)) ? isPalin[j + 1] : false;
                if (isPalin[j]) {
                    dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
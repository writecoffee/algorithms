public class palindrome_partitioning_min_cut {
    /**
     * First we can fill in a table to determine whether substring s[i, j] could form
     * a palindrome. (Rotating the table 45 degree, we are filling the table from left
     * to right, from bottom to top.
     * 
     * Then we gradually increase the subproblem size, the length of s, to find the 
     * minimum cut for the current substring s[0, k]. The idea is standing at position
     * i (in length k, i = k, starting off from position 0), if substring s[i, k - 1] is
     * a palindrome, then we get a possible cut for this partitioning, which is dp[i - 1] + 1.
     * 
     */
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            isPalin[i][i] = true;
        }

        for (int i = 0; i < n - 1; ++i) {
            isPalin[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        for (int k = 3; k <= n; ++k) {
            for (int j = 0; j <= n - k; ++j) {
                isPalin[j][j + k - 1] = s.charAt(j) == s.charAt(j + k - 1) && isPalin[j + 1][j + k - 2];
            }
        }

        int[] dp = new int[n];

        for (int i = 1; i < n; ++i) {
            dp[i] = i;

            for (int j = i; j >= 0; --j) {
                if (isPalin[j][i] && j == 0) {
                    dp[i] = 0;
                } else if (isPalin[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }

        return dp[n - 1];
    }

    public int minCutOptimized(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        int[] dp = new int[n];

        for (int k = 0; k < n; ++k) {
            dp[k] = k;

            for (int i = k; i >= 0; --i) {
                if (s.charAt(i) == s.charAt(k) && k - i == 0) {
                    isPalin[i][k] = true;
                } else if (s.charAt(i) == s.charAt(k) && k - i == 1) {
                    isPalin[i][k] = true;
                } else if (s.charAt(i) == s.charAt(k) && isPalin[i + 1][k - 1]) {
                    isPalin[i][k] = true;
                }

                if (isPalin[i][k] && i == 0) {
                    dp[k] = 0;
                } else if (isPalin[i][k]) {
                    dp[k] = Math.min(dp[k], dp[i - 1] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}
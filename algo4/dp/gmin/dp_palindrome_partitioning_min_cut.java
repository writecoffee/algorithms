package gmin;

public class dp_palindrome_partitioning_min_cut {
    /**
     * Devise a recursive function to represent the min-cut for sub-problem s[0 .. k - 1],
     * a.k.a, length of k.
     * 
     * R(k) = min { k - 1,
     *              for i in range(0, k - 1)
     *                  R(i) + 1    (if s[i .. k - 1] is a palindrome) (1)
     *                  k - 1       (otherwise)
     *            }.
     * 
     * For problem (1), if we can devise a function to memorize whether s[i .. k - 1] is a
     * palindrome, then we can save a lot of time for computing the overlapping problem again.
     * 
     * So, we have
     * 
     * B(i, j) is true when B(i + 1, j - 1) && s[i] == s[j], false otherwise
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
            for (int i = 0; i <= n - k; ++i) {
                isPalin[i][i + k - 1] = s.charAt(i) == s.charAt(i + k - 1) && isPalin[i + 1][i + k - 2];
            }
        }

        int[] dp = new int[n + 1];
        dp[0] = -1;

        for (int k = 1; k <= n; ++k) {
            dp[k] = k - 1;
            for (int i = k - 1; i >= 0; --i) {
                dp[k] = Math.min(dp[k], isPalin[i][k - 1] ? dp[i] + 1 : k - 1);
            }
        }

        return dp[n];
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
package string;

public class dp_longest_palindrome_subsequence_length {
    /**
     * We describe the recurrence in terms of T(i, j), representing the length of the
     * longest palindrome consisting of characters from i to j inclusive.
     * 
     * T(i, j) = T(i + 1, j - 1)                if s[i] == s[j]
     *           max(T(i + 1, j), T(i, j - 1))  if s[i] != s[j]
     *
     */
    public int getLongest(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < n - 1; ++i) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2 : 1;
        }

        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i <= n - k; ++i) {
                if (s.charAt(i) == s.charAt(i + k - 1)) {
                    dp[i][i + k - 1] = dp[i + 1][i + k - 2] + 2;
                } else {
                    dp[i][i + k - 1] = Math.max(dp[i + 1][i + k - 1], dp[i][i + k - 2]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
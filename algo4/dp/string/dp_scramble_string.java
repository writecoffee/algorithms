package string;

public class dp_scramble_string {
    /**
     * We can construct a 3-d table using k to denote the length of the substring
     * of s1 and s2, and use i, j to denote the starting point in s1 and s2 respectively.
     * 
     * R(k, i, j) holds only when there is a p within range [1, k - 1] such that
     * 
     *      (1) R(p, i, j) && R(k - p, i + p, j + p) holds
     *   or (2) R(k - p, i, j + p) && R(p, i + k - p, j) holds
     *   
     * So we are filling the table in a bottom-up manner.
     * 
     */
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        boolean[][][] dp = new boolean[n + 1][n + 1][n + 1];
        dp[0][0][0] = true;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 2; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                for (int j = 0; j < n - k + 1; ++j) {
                    for (int p = 1; p < k; ++p) {
                        if ((dp[p][i][j] && dp[k - p][i + p][j + p]) ||
                            (dp[k - p][i][j + p] && dp[p][i + k - p][j])) {
                            dp[k][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        return dp[n][0][0];
    }
}
public class scramble_string {
    public static boolean isScramble(String s1, String s2) {
        int len = s1.length();

        if (len != s2.length()) {
            return false;
        }

        boolean[][][] dp = new boolean[len + 1][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }

        for (int k = 2; k < len + 1; k++) {
            for (int i = 0; i < len - k + 1; i++) {
                for (int j = 0; j < len - k + 1; j++) {
                    for (int p = 1; p < k; p++) {
                        if ((dp[p][i][j] && dp[k - p][i + p][j + p])
                         || (dp[p][i][j + k - p] && dp[k - p][i + p][j])) {
                            dp[k][i][j] = true;
                        }
                    }
                }
            }
        }

        return dp[len][0][0];
    }

    public static void main(String[] args) {
        assert isScramble("great", "rgtae");
        assert isScramble("a", "a");
        assert isScramble("ba", "ab");
    }
}
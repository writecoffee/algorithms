
public class scramble_string {
    public static boolean isScramble(String s1, String s2) {
        int len = s1.length();

        if (len != s2.length()) {
            return false;
        }

        if (s1.equals(s2)) {
            return true;
        }

        boolean[][][] dp = new boolean[len + 1][len][len];
        for (int k = 1; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                for (int j = 0; j <= len - k; j++) {
                    if (k == 1) {
                        dp[1][i][j] = (s1.charAt(i) == s2.charAt(j));
                    }

                    for (int p = 1; p < k && !dp[k][i][j]; p++) {
                        if (dp[p][i][j] && dp[k - p][i + p][j + p] || dp[p][i][j + k - p] && dp[k - p][i + p][j]) {
                            dp[k][i][j] = true;
                        }
                    }
                }
            }
        }

        return dp[len][0][0];
    }

    public static void main(String[] args) {
        isScramble("great", "rgtae");
    }
}
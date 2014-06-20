package basic;

/**
 * Given two words word1 and word2, determine whether we just need operation to change
 * from word1 to word2.
 * 
 * Example:
 * 
 * cat, cast    => True, we insert 's' from word1
 * cat, at      => True, we replace 'a' with 'o'
 * cat, dog     => False
 * cat, cat     => False, we don't need any transformation
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview
 *
 */
public class dp_edit_distance_is_one_operation_trasformation {
    /**
     * As an example, let s1 = "am", s2 = "a", we start off from looking at the last characters of
     * these two string. Because 'm' != 'a', we can regard replacing 'm' with 'a', requiring one
     * operation. We can also think of deleting 'm' from s1 and see if we can change from 'a' to
     * 'a'. Lastly, we can also think of adding 'a' to s1 and see how we change from "am" to "".
     * 
     * So in order to enumerate all possible editing sequences, this require us O(3 ^ min(m, n))
     * time complexity. And hence we can think of using the dynamic programming method we used to
     * compute edit distance between s1 and s2.
     * 
     */
    public boolean isOneStepEdit(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s2.charAt(j - 1) == s1.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[m][n] == 1;
    }

    public boolean minDistanceImproved(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[] dp = new int[n + 1];

        for (int j = 1; j <= n; ++j) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; ++i) {
            int t1 = dp[0];
            dp[0] = i;
 
            for (int j = 1; j <= n; ++j) {
                int t2 = dp[j];

                if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
                    dp[j] = 1 + Math.min(Math.min(dp[j], dp[j - 1]), t1);
                } else {
                    dp[j] = t1;
                }

                t1 = t2;
            }
        }

        return dp[n] == 1;
    }
}
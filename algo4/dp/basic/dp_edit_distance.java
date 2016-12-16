package basic;

/**
 * Given two words word1 and word2, find the minimum number of steps required to
 * convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *
 *    a) Insert a character
 *    b) Delete a character
 *    c) Replace a character
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/edit-distance/}
 *
 */
public class dp_edit_distance {
    /**
     * We can let dp[i][j] to represent the edit distance between s1[0 .. i - 1]
     * and s2[0 .. j - 1]. Every time we are computing the new entry dp[i][j],
     * there will be two cases to discuss.
     *
     * If s1[i] == s2[j], we can reuse the result of dp[i - 1][j - 1] and concatenate
     * the last character of either s1 or s2 since they are the same.
     *
     * If s1[i] != s2[j], there will be three cases to think about. We can think of
     * replacing s1[i] with s2[j] and reuse dp[i - 1][j - 1], or adding s2[j] to the
     * result of changing s1[0 .. i] to s2[0 .. j - 1], or deleting s1[i] then look
     * up entry dp[i - 1][j] where we changed s1[0 .. i - 1] to s2[0 .. j].
     *
     */
    public int minDistance(String s1, String s2)
    {
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

        return dp[m][n];
    }

    public int minDistanceImproved(String s1, String s2)
    {
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

        return dp[n];
    }
}

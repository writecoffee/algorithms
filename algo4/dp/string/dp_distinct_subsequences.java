package string;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions of
 * the remaining characters. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * 
 * S = "rabbbit", T = "rabbit"  
 * 
 * Return 3.
 * 
 */
public class dp_distinct_subsequences {
    public int numDistinct(String s, String t) {
        return explore(s, t, 0, 0);
    }

    private int explore(String s, String t, int i, int j) {
        int result = 0;
        int m = s.length(), n = t.length();

        if (j == n) {
            return 1;
        }
 
        for (; i < m; ++i) {
            if (s.charAt(i) == t.charAt(j)) {
                result += explore(s, t, i + 1, j + 1);
            }
        }

        return result;
    }

    /**
     * The key observation here is that for s[0 .. i] and t[0 .. j],
     * if s[i] == t[j], then we can 
     * 
     *      (1) chop off the last character on both string and get result from s[0 .. i - 1]
     *          and t[0 .. j - 1]; 
     *      (2) chop off the last character on string s and get result from s[0 .. i - 1]
     *          and t[0 .. j].
     * 
     * Otherwise, we can only inherit the result from sub-problem s[0 .. i - 1], t[0 .. j]
     * and expect there would be a character after s[i] to match t[j].
     * 
     * Also note that when t[0 .. j] is longer than s[0 .. i], we are assured that there
     * will be no possible subsequence for that situation. Thus we have smaller boundary for
     * the inner column iteration.
     * 
     */
    public int numDistinctImproved(String s, String t) {
        int m = s.length(), n = t.length();

        if (m < n) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;

        for (int i = 1; i < m; ++i) {
            dp[i][0] = s.charAt(i) == t.charAt(0) ? dp[i - 1][0] + 1 : dp[i - 1][0];
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < Math.min(n, i + 1); ++j) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int numDistinctOptimized(String s, String t) {
        int m = s.length(), n = t.length();

        if (m < n) {
            return 0;
        }

        int[] dp = new int[n];

        for (int i = 0; i < m; ++i) {
            int pre = dp[0];
            dp[0] = s.charAt(i) == t.charAt(0) ? dp[0] + 1 : dp[0];

            for (int j = 1; j < Math.min(n, i + 1); ++j) {
                int tPre = dp[j];

                if (s.charAt(i) == t.charAt(j)) {
                    dp[j] = pre + dp[j];
                }

                pre = tPre;
            }
        }

        return dp[n - 1];
    }
}
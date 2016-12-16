package string;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/wildcard-matching/}
 * [Difficulty] - Medium
 *
 */
public class dp_str_wildcard_matching
{
    /**
     * Let t = "aaaab", p = "aa*b"
     *
     * When pc == '*', we need to consider 2 cases:
     *   (1) skip this '*' for matching
     *   (2) use "a*" to match one or more than one 'a' in t.
     *
     * dp[i][j] denotes prefix substring t[0 .. i], p[0 .. j] matches or not.
     *
     * dp[i][j] = if p_j == '*':
     *                  dp[i - 1][j] || dp[i][j - 1]
     *            else:
     *                  dp[i - 1][j - 1] && isCharMatch(t_i, p_j)
     *
     */
    public boolean isMatch(String t, String p)
    {
        int m = t.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            char tc = t.charAt(i - 1);

            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);

                if (pc == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = isCharMatch(tc, pc) && dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    private boolean isCharMatch(char tc, char pc)
    {
        return pc == '?' || pc == tc;
    }
}

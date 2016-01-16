package gmax;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 *
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 *
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/longest-valid-parentheses/}
 * [Difficulty] - Hard
 *
 */
public class dp_gmax_longest_valid_parentheses
{
    /**
     * DP[i]: Ending at i - 1, the length of longest VALID parentheses substring.
     *
     * (1) s[i - 1] == '(':
     *      DP[i] = 0
     *
     * (2) s[i - 1] == ')':
     *      let j = i - 2 - DP[i - 1]
     *      => heuristically looking backward from i, trying to see if s[j] == '(' which
     *         can match up with s[i - 1].
     *
     *     So,
     *
     *     (a) s[j] == '(':
     *
     *         DP[i] = DP[i - 1] + 2 (pair of parentheses) + DP[j]
     *
     *     (b) s[j] == ')':
     *
     *         DP[i] = 0
     *
     */
    public int longestValidParentheseDp(String s)
    {
        int n = s.length();
        int gMax = 0;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int j = i - 2 - dp[i - 1];

            if (s.charAt(i - 1) == '(' || j < 0 || s.charAt(j) == ')') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 2 + dp[j];
                gMax = Math.max(gMax, dp[i]);
            }
        }

        return gMax;
    }
}

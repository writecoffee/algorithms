package string;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into
 * a space-separated sequence of one or more dictionary words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 *
 * R(i): is true only when there is a j from 0 to i - 1 (inclusively),
 *       s.substring(j, i) is in dictionary and R(j) holds.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/word-break/}
 *
 */
public class dp_word_break_possible_partitioning
{
    public boolean wordBreak(String s, Set<String> dict)
    {
        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; ++i) {
            for (int j = i; j >= 0; --j) {
                if (dict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}

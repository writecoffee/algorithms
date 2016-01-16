package window;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc". The length
 * is 3.
 *
 * For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/longest-substring-without-repeating-characters/}
 *                {@linkplain https://leetcode.com/problems/longest-substring-without-repeating-characters/}
 * [Difficulty] - Medium
 *
 */
public class tp_longest_substring_without_repeating_characters
{
    /**
     * Have a sliding window, we move the right bound only if the character we encounter doesn't
     * exist in our table. We move the left bound for throwing duplicate character in order to let
     * the right bound to move on.
     *
     * Have a running maximum variable to record the maximum window during the course of variation.
     *
     */
    public int lengthOfLongestSubstring(String s)
    {
        boolean[] h = new boolean[256];
        int result = 0;
        int n = s.length();

        for (int i = 0, j = 0; i < n; i++) {
            for (; j < n && !h[s.charAt(j)]; j++) {
                h[s.charAt(j)] = true;
            }

            result = Math.max(result, j - i);
            h[s.charAt(i)] = false;
        }

        return result;
    }
}

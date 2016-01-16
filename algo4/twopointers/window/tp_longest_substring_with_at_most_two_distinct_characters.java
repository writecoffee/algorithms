package window;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 *
 * For example, Given s = “eceba”,
 *
 * T is "ece" which its length is 3.
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/}
 *
 */
public class tp_longest_substring_with_at_most_two_distinct_characters
{
    public int lengthOfLongestSubstringTwoDistinct(String s)
    {
        int n = s.length();
        int distinct = 0;
        int[] h = new int[256];
        int result = 0;

        for (int i = 0, j = 0; i < n; i++) {
            for (; j < n && distinct <= 2; j++) {
                char c = s.charAt(j);
                h[c]++;
                if (h[c] == 1) {
                    distinct++;
                }
            }

            /*
             * Edge case where only 1 distinct character appears in the string.
             */
            if (distinct == 3) {
                result = Math.max(result, j - i - 1);
            } else {
                result = Math.max(result, j - i);
            }

            char backchar = s.charAt(i);
            h[backchar]--;
            if (h[backchar] == 0) {
                distinct--;
            }
        }

        return result;
    }
}

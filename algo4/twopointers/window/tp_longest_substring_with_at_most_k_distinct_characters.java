package window;

/**
 * Given a string s, find the length of the longest substring T that contains at
 * most k distinct characters.
 *
 * For example, Given s = "eceba", k = 3,
 *
 * T is "eceb" which its length is 4.
 *
 * Challenge O(n), n is the size of the string s.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/longest-substring-with-at-most-k-distinct-characters/}
 *                {@linkplain https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/}
 * [Difficulty] - Medium
 *
 */
public class tp_longest_substring_with_at_most_k_distinct_characters
{
    public int lengthOfLongestSubstringKDistinct(String s, int k)
    {
        int n = s.length();
        int distinct = 0;
        int[] h = new int[256];
        int result = 0;

        for (int l = 0, r = 0; l < n; l++) {
            for (; r < n && distinct <= k; r++) {
                char c = s.charAt(r);
                h[c]++;
                if (h[c] == 1) {
                    distinct++;
                }
            }

            if (distinct == k + 1) {
                result = Math.max(result, r - l - 1);
            } else {
                result = Math.max(result, r - l);
            }

            char backchar = s.charAt(l);
            h[backchar]--;
            if (h[backchar] == 0) {
                distinct--;
            }
        }

        return result;
    }
}

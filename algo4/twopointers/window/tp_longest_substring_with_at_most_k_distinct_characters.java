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

        for (int i = 0, j = 0; i < n; i++) {
            for (; j < n && distinct <= k; j++) {
                char c = s.charAt(j);
                h[c]++;
                if (h[c] == 1) {
                    distinct++;
                }
            }

            if (distinct == k + 1) {
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

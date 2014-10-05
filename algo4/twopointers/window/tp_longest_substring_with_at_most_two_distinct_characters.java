package window;

/**
 * Given a string, find the length of the longest substring T that contains at
 * most 2 distinct characters.
 *
 * For example, Given s = “eceba”,
 *
 * T is "ece" which its length is 3.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/}
 *
 */
public class tp_longest_substring_with_at_most_two_distinct_characters
{
    public int lengthOfLongestSubstringTwoDistinct(String s)
    {
        int n = s.length(),
            l = 0,
            gMax = 0,
            distinct = 0;

        int[] h = new int[256];

        for (int r = 0; r < n; ++r) {
            char c = s.charAt(r);

            if (!(distinct < 2 || h[c] > 0)) {
                for (char cPrev = s.charAt(l); l < r - 1 && distinct == 2; ++l, cPrev = s.charAt(l)) {
                    h[cPrev]--;
                    if (h[cPrev] == 0) {
                        distinct--;
                    }
                }
            }

            if (h[c] == 0) {
                distinct++;
            }
            h[c]++;

            gMax = Math.max(r - l + 1, gMax);
        }

        return gMax;
    }
}

package window;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc". The length
 * is 3.
 * 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 */
public class tp_longest_substring_without_repeating_characters {
    /**
     * Have a sliding window, we move the right bound only if the character we encounter doesn't
     * exist in our table. We move the left bound for throwing duplicate character in order to let
     * the right bound to move on.
     * 
     * Have a running maximum varaible to record the maximum window during the course of variation.
     * 
     */
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int gMax = 0;
        int n = s.length();

        for (int l = 0, r = 0; r < n && l + gMax < n;) {
            char c = s.charAt(r);

            if (exist[c]) {
                exist[s.charAt(l++)] = false;
            } else {
                exist[c] = true;
                r++;
            }

            gMax = Math.max(gMax, r - l);
        }

        return gMax;
    }
}
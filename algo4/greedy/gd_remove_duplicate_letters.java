/**
 * Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 *
 * Example:
 *
 * Given "bcabc"
 * Return "abc"
 *
 * Given "cbacdcbc"
 * Return "acdb"
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/remove-duplicate-letters/}
 * [Difficulty] - Medium
 *
 */
public class gd_remove_duplicate_letters
{
    /**
     * Given the string s, the greedy choice (i.e., the leftmost letter in the
     * answer) is the smallest s[i], s.t. the suffix s[i .. ] contains all the
     * unique letters. (Note that, when there are more than one smallest s[i]'s,
     * we choose the leftmost one. Why? Simply consider the example: "abcacb".)
     *
     * After determining the greedy choice s[i], we get a new string s' from s
     * by
     *
     * 1. removing all letters to the left of s[i],
     * 2. removing all s[i]'s from s.
     *
     * We then recursively solve the problem w.r.t. s'.
     *
     * The runtime is O(26 * n) = O(n).
     *
     */
    public String removeDuplicateLetters(String s)
    {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }

            if (--cnt[s.charAt(i) - 'a'] == 0) {
                break;
            }
        }

        return s.length() == 0 ? ""
             : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}

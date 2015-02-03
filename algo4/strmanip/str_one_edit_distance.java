/**
 * Given two strings S and T, determine if they are both one edit distance
 * apart.
 *
 * [Difficulty]     - Easy
 * [Tediousness]    - Medium
 * [Source]         - {@linkplain https://leetcode.com/problems/one-edit-distance/}
 *
 */
public class str_one_edit_distance
{
    public static boolean isOneEditDistance(String s, String t)
    {
        int m = s.length(), n = t.length();

        if (m < n) {
            return isOneEditDistance(t, s);
        } else if (m - n > 1) {
            return false;
        }

        int i = 0, shift = 0;

        for (; i < m && i < n && s.charAt(i) == t.charAt(i); i++) {
        }

        if (i == n && i == m) {
            return false;
        } else if (m > n && i == n) {
            return true;
        } else if (m > n) {
            shift++;
        } else {
            i++;
        }

        for (; i < n && s.charAt(i + shift) == t.charAt(i); i++) {
        }

        return i == n;
    }
}

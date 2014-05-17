/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum
 * length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * The idea to solve the problem is to expand from each character to find the longest palindrome from
 * that character can reach.
 * 
 * It needs O(n ^ 2) time complexity and O(1) space complexity.
 * 
 */
public class tp_longest_palindrome_substring {
    public String longestPalindrome(String s) {
        String result = "";
        int n = s.length();

        for (int i = 0; i < n - result.length() / 2; ++i) {
            String t = expand(s, i, i);
            result = t.length() > result.length() ? t : result;
        }

        for (int i = 1; i < n - result.length() / 2; ++i) {
            String t = expand(s, i - 1, i);
            result = t.length() > result.length() ? t : result;
        }

        return result;
    }

    private String expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r);
    }
}
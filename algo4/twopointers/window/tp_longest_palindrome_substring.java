package window;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum
 * length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * The idea to solve the problem is to expand from each character to find the longest palindrome from
 * that character can reach.
 * 
 * It needs O(n ^ 2) time complexity and O(1) space complexity.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/longest-palindromic-substring/}
 * 
 */
public class tp_longest_palindrome_substring
{
    public String longestPalindrome(String s)
    {
        int n = s.length();
        String result = "";

        for (int i = 0; i < n - result.length() / 2; ++i) {
            result = expand(i - 1, i + 1, n, s, result);
            result = expand(i, i + 1, n, s, result);
        }

        return result;
    }

    private String expand(int l, int r, int n, String s, String result)
    {
        for (; l >= 0 && r < n; --l, ++r) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
        }

        return (result = r - l - 1 > result.length() ? s.substring(l + 1, r) : result);
    }

    public String longestPalindromeManchesterAlgorithms(String s)
    {
        if (s == null || s.length() == 0) {
            return "";
        }

        int n = s.length();
        int max = 0;
        String result = "";

        for (int i = 1; i <= 2 * n - 1; i++) {
            int count = 1;

            while (i - count >= 0 && i + count <= 2 * n && get(s, i - count) == get(s, i + count)) {
                count++;
            }

            count--; // there will be one extra count for the outbound #
            if (count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }

        return result;
    }

    private char get(String s, int i)
    {
        if (i % 2 == 0) {
            return '#';
        } else {
            return s.charAt(i / 2);
        }
    }
}

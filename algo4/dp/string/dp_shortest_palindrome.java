package string;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding
 * characters in front of it. Find and return the shortest palindrome you can
 * find by performing this transformation.
 *
 * For example:
 *
 * Given "aacecaaa", return "aaacecaaa".
 *
 * Given "abcd", return "dcbabcd".
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/shortest-palindrome/}
 *
 */
public class dp_shortest_palindrome
{
    public String shortestPalindrome(String s)
    {
        int n = s.length(), start = 1;
        if (n == 0) {
            return "";
        }

        boolean[][] isPalindrom = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            isPalindrom[i][i] = true;
        }

        for (int k = 2; k <= n; ++k) {
            isPalindrom[0][k - 1] = s.charAt(0) == s.charAt(k - 1) && isPalindrom[0][k - 2];
            if (isPalindrom[0][k - 1]) {
                start = k;
            }

            for (int i = 1; i < n - k; ++i) {
                char l = s.charAt(i),
                     r = s.charAt(i + k - 1);

                isPalindrom[i][i + k - 1] = l == r && isPalindrom[i][i + k - 2];
            }
        }

        return reverse(s.substring(start, n)).append(s).toString();
    }

    public String shortestPalindromeOptimizedMemory(String s)
    {
        int n = s.length(), start = 1;
        if (n == 0) {
            return "";
        }

        boolean[][] isPalindrom = new boolean[2][n];
        for (int i = 0; i < n; ++i) {
            isPalindrom[1][i] = true;
        }

        for (int k = 2; k <= n; ++k) {
            isPalindrom[k % 2][0] = s.charAt(0) == s.charAt(k - 1) && isPalindrom[(k - 1) % 2][0];
            if (isPalindrom[k % 2][0]) {
                start = k;
            }

            for (int i = 1; i <= n - k; ++i) {
                char l = s.charAt(i),
                     r = s.charAt(i + k - 1);

                isPalindrom[k % 2][i] = l == r && isPalindrom[(k - 1) % 2][i + k - 2];
            }
        }

        return reverse(s.substring(start, n)).append(s).toString();
    }

    private StringBuilder reverse(String tail)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = tail.length() - 1; i >= 0; --i) {
            sb.append(tail.charAt(i));
        }

        return sb;
    }
}

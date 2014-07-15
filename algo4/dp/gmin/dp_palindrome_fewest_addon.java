package gmin;

/**
 * A palindrome is a string which reads the same forward and backwards. You are provided
 * a function shortPalin which accepts a string S.
 * 
 * You are required to form a palindrome by adding 0 or more characters to the string at
 * any location which you find appropriate. Return the minimum number of characters which
 * needs to be added to the string to transform it into a palindrome. The section of the
 * program which parses the input and displays the output will be handled by us. Your task
 * is to complete the body of the function or method provided, and to return the correct output.
 * 
 * Sample input #00: 
 * String(S): abab
 * 
 * Sample output #00:
 * 1
 * 
 * Explanation:
 * A palindrome can be obtained by simply adding an 'a' to the string to form 'ababa'.
 * 
 * Sample input #01: 
 * String(S): abacaba
 * 
 * Sample output #01:
 * 0
 * 
 * Sample input #02: 
 * String(S): abca
 * 
 * Sample output #02:
 * 1
 * 
 * Explanation:
 * The given string is already a palindrome. No characters need to be added to it.
 * 
 * [Difficulty] - Hard
 * [Source]     - snapchat quiz
 *
 */
public class dp_palindrome_fewest_addon {
    public int fewestAddon(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i <= n - 2; ++i) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 0 : 1;
        }

        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i <= n - k; ++i) {
                if (s.charAt(i) == s.charAt(i + k - 1)) {
                    dp[i][i + k - 1] = dp[i + 1][i + k - 2];
                } else {
                    dp[i][i + k - 1] = 1 + Math.min(dp[i + 1][i + k - 1], dp[i][i + k - 2]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
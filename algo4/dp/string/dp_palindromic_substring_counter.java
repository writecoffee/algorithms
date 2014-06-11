package string;

/**
 * Count the number of palindromic substring for a given string.
 * 
 * For example:
 * 
 * abba --> abba, bb = 2
 * 
 * where we count duplicate and don't count for single character.
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview
 *
 */
public class dp_palindromic_substring_counter {
    public int countPalindromicSubstring(String s) {
        int n = s.length();
        boolean[][] isPalin = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; ++i) {
            isPalin[i][i] = true;
        }

        for (int i = 0; i < n - 1; ++i) {
            isPalin[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (isPalin[i][i + 1]) {
                count++;
            }
        }

        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i <= n - k; ++i) {
                isPalin[i][i + k - 1] = s.charAt(i) == s.charAt(i + k - 1) && isPalin[i + 1][i + k - 2];
                if (isPalin[i][i + k - 1]) {
                    count++;
                }
            }
        }

        return count;
    }
}
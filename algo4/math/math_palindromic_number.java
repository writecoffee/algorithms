/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * 
 * Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction of using extra
 * space.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/palindrome-number/}
 * 
 */
public class math_palindromic_number {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        while (x > 0) {
            if (x / div != x % 10) {
                return false;
            }

            x = x % div / 10;
            div /= 100;
        }

        return true;
    }
}
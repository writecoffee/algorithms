package window;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and
 * ignoring cases.
 * 
 * For example,
 * 
 * "A man, a plan, a canal: Panama" is a palindrome.
 * 
 * "race a car" is not a palindrome.
 * 
 * This is a variation of the previous problem. Now if there is no letter in the string, we should
 * regard the input as non-palindrom.
 * 
 * "$!#$!!!" is not a palindrom.
 * 
 * "" is also not a palindrom.
 * 
 * [Difficulty] - Easy
 * [Source]     - facebook interview
 * 
 */
public class tp_validate_palindrome_II {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }

        int n = s.length();

        for (int l = 0, r = n - 1; l <= r; ++l, --r) {
            while (l <= r && !Character.isLetter(s.charAt(l))) {
                l++;
            }

            if (l == n) {
                return false;
            } else if (l > r) {
                break;
            }

            while (l < r && !Character.isLetter(s.charAt(r))) {
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
        }

        return true;
    }
}
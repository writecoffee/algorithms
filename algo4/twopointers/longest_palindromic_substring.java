public class longest_palindromic_substring {
    private static String findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public static String longestPalindrome(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); ++i) {
            String palindrome = findPalindrome(s, i, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }

        for (int i = 1; i < s.length(); ++i) {
            String palindrome = findPalindrome(s, i - 1, i);
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }

        return longest;
    }

    public String longestPalindromeImprov(String s) {
        int n = s.length();
        String longest = "";

        for (int i = 0; i < s.length() - longest.length() / 2; ++i) {
            int left = i, right = i;

            for (; left >= 0 && right < n && s.charAt(left) == s.charAt(right); --left, ++right)
                ;

            /**
             * If the odd case produces the longest and reaches an end, we don't need to check the
             * even case since it must be shorter.
             */
            if (right - left - 1 > longest.length()) {
                longest = s.substring(left + 1, right);
                if (left < 0 || right == n) {
                    continue;
                }
            }

            left = i - 1;
            right = i;
            for (; left >= 0 && right < n && s.charAt(left) == s.charAt(right); --left, ++right)
                ;

            if (right - left - 1 > longest.length()) {
                longest = s.substring(left + 1, right);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        longestPalindrome("aabaa");
    }
}
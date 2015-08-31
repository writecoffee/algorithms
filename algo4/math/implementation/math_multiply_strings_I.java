/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/multiply-strings/}
 * 
 */
public class math_multiply_strings_I {
    public String multiply(String a, String b) {
        int m = a.length(), n = b.length();
        int[] result = new int[m + n];

        for (int i = 0; i < n; ++i) {
            int carry = 0;
            int bVal = b.charAt(n - 1 - i) - '0';

            for (int j = 0; j < m; ++j) {
                int aVal = a.charAt(m - 1 - j) - '0';
                int t = aVal * bVal + carry + result[m + n - 1 - i - j];
                result[m + n - 1 - i - j] = t % 10;
                carry = t / 10;
            }

            result[m + n - 1 - i - m] += carry;
        }

        int i = 0;
        while (i < m + n && result[i] == 0) {
            ++i;
        }

        return convert(result, i, m + n);
    }

    private String convert(int[] result, int start, int end) {
        if (start == end) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; ++i) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
}
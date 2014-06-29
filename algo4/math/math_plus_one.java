/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/plus-one/}
 * 
 */
public class math_plus_one {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int start = n - 1;

        for (; start >= 0 && digits[start] == 9; --start)
            ;

        int m = start < 0 ? n + 1 : n;
        int[] result = new int[m];

        int carry = 1;
        for (int j = start; j >= 0; --j) {
            result[j + (m - n)] = (digits[j] + carry) % 10;
            carry = (digits[j] + carry) / 10;
        }

        result[0] += carry;
        return result;
    }
}
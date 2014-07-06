package conversion;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint:
 * 
 * Carefully consider all possible input cases. If you want a challenge, please do not see below and
 * ask yourself what are the possible input cases.
 * 
 * Notes:
 * 
 * It is intended for this problem to be specified vaguely (ie, no given input specs). You are
 * responsible to gather all the input requirements up front.
 * 
 * Requirements for atoi:
 * 
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional initial
 * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
 * numerical value.
 * 
 * The string can contain additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if
 * no such sequence exists because either str is empty or it contains only whitespace characters, no
 * conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out
 * of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/string-to-integer-atoi/}
 * 
 */
public class math_conv_string_to_integer {
    public int atoi(String str) {
        int n = str.length();
        long result = 0;
        int sign = 1;
        int i = 0;

        if (n == 0) {
            return 0;
        }

        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        for (; i < n && Character.isDigit(str.charAt(i)); ++i) {
            result = result * 10 + (int) (str.charAt(i) - '0');
        }

        result *= sign;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}
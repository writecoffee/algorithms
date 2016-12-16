/**
 * Validate if a given string is numeric.
 *
 * Some examples:
 *
 *    "0"       => true
 *    " 0.1 "   => true
 *    "abc"     => false
 *    "1 a"     => false
 *    "2e10"    => true
 *    "2e1.0"    => false
 *    "2e+3"    => true
 *    "2e+3.5"    => false
 *
 * Scientific notation in java:
 *
 * Section 3.10.2 of the JLS talks about floating-point literals in Java.
 * In short, provide the decimal part as if it were scientific notation,
 * but instead of x 10^23 you would write e23:
 *
 * 3.30e23
 *
 * To write one with a negative exponent, you can do that easily also for
 * 6.67 x 10^(-11):
 *
 * 6.67e−11
 *
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 *
 * Using e is only a shorthand to simplify the writing of a number, and
 * can be followed either by a (signed) float number or integer. It does
 * not involve any (mathematical) computation, only shifting the decimal
 * mark.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/valid-number/}
 *
 */
public class stm_validate_number_I
{
    /**
     * Check the positions of e/E, dot, and +/-.
     *
     * Specifically,
     *
     *  (1) dot must be in the front of e/E,
     *  (2) e/E must be in the RIGHT front of +/-
     *  (3) +/- must have a following digit
     *  (4) e/E cannot be in the first and last position;
     *  (5) dot is not the unique char of string, and if dot is the first char, the next char cannot be e/E.
     */
    public boolean isNumber(String s)
    {
        int len = s.length();
        int i = 0, end = len - 1;

        while (i <= end && Character.isWhitespace(s.charAt(i))) {
            i++;
        }

        if (i > len - 1) {
            return false;
        }

        while (end >= i && Character.isWhitespace(s.charAt(end))) {
            end--;
        }

        // skip leading +/-
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }

        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean exp = false; // is a 'e'

        for (; i <= end; i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = true;

            } else if (c == '.') {
                if (exp || dot) {
                    return false;
                }

                dot = true;

            } else if (c == 'e') {
                if (exp || num == false) {
                    return false;
                }

                exp = true;
                num = false;

            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != 'e') {
                    return false;
                }

            } else {
                return false;
            }
        }

        return num;
    }
}

/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain https://oj.leetcode.com/problems/divide-two-integers/}
 *
 */
public class math_divide_two_integers {
    public int divide(int dividend, int divisor) {
        int neg = 1 << 31;
        boolean isNeg = ((dividend & neg) == 0 && (divisor & neg) != 0)
                     || ((dividend & neg) != 0 && (divisor & neg) == 0);

        long a = Math.abs((long) dividend), b = Math.abs((long) divisor), quotient = 0;

        while (a >= b) {
            long prod = b, q = 1;

            while ((prod << 1) <= a) {
                prod <<= 1;
                q <<= 1;
            }

            a -= prod;
            quotient += q;
        }

        return isNeg ? ~((int) quotient) + 1 : (int) quotient;
    }
}
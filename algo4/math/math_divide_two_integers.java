/**
 * Divide two integers without using multiplication, division and mod operator.
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain https://oj.leetcode.com/problems/divide-two-integers/}
 *
 */
public class math_divide_two_integers
{
    public int divide(int numerator, int denominator)
    {
        if (numerator == 0) {
            return 0;
        } else if (denominator == 0) {
            return Integer.MAX_VALUE;
        }

        long neg = ((numerator < 0) ^ (denominator < 0)) ? -1 : 1,
             n = Math.abs((long) numerator),
             d = Math.abs((long) denominator),
             quotient = 0;

        while (n >= d) {
            long tq = 1, td = d;

            while ((td << 1) <= n) {
                td <<= 1;
                tq <<= 1;
            }

            quotient += tq;
            n -= td;
        }

        return (int) Math.min((long) Integer.MAX_VALUE, neg * quotient);
    }
}

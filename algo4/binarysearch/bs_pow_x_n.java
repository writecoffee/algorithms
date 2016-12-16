/**
 * Pow(x, n)
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/powx-n/}
 * [Difficulty] - Medium
 *
 */
public class bs_pow_x_n
{
    /**
     * For recursive version, the basic idea is to decompose the exponent
     * into powers of 2, so that we can keep dividing the problem in half.
     *
     *    x^9 => x(x^4)^2 => ...
     */
    public double myPow(double x, int n)
    {
        if (n > 0) {
            return breakDown(x, n);
        } else {
            return 1 / breakDown(x, -n);
        }
    }

    private double breakDown(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double halfResult = breakDown(x, n >> 1);

        if ((n & 1) == 0) {
            return halfResult * halfResult;
        } else {
            return x * halfResult * halfResult;
        }
    }

    /**
     * The basic idea is to decompose the exponent into powers of 2,
     * so that we can keep dividing the problem in half.
     *
     * e.g.
     *
     * N = 9 = 2^3 + 2^0 = 1001 in binary. Then
     * x^9 = x^(2^3) * x^(2^0)
     *
     */
    public double myPowIterative(double x, int n) {
        if (n < 0) {
            return 1 / myPowIterative(x, -n);
        }

        double result = 1;

        while (n > 0) {
            if ((n & 1) == 1) {
                result *= x;
            }

            n >>= 1;
            x *= x;
        }

        return result;
    }
}

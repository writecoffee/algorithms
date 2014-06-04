public class divide_two_integers {
    public int divide(int dividend, int divisor) {
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long quotient = 0;

        while (a >= b) {
            long div = b;
            long q = 1;

            while ((div << 1) <= a) {
                div <<= 1;
                q <<= 1;
            }

            a -= div;
            quotient += q;
        }

        return (int) quotient * sign;
    }
}

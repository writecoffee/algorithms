public class divide_two_integers {
    public static int divide(int dividend, int divisor) {
        int negFlag = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -1 : 1;
        long result = 0;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        while (a >= b) {
            long div = b;
            long quotient = 1;
            while ((div << 1) <= a) {
                div <<= 1;
                quotient <<= 1;
            }

            a -= div;
            result += quotient;
        }

        return (int) result * negFlag;
    }
}
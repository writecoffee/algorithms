public class divide_two_integers {

    public static int divide(int dividend, int divisor) {
        assert divisor != 0;

        boolean negativeFlag = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        int result = 0;

        while (absDividend >= absDivisor) {
            long div = absDivisor;
            long quotient = 1;
            while ((div << 1) <= absDividend) {
                div <<= 1;
                quotient <<= 1;
            }

            absDividend -= div;
            result += quotient;
        }

        return negativeFlag ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(divide(-1010369383, -2147483648));
    }
}
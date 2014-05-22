public class reverse_integer {
    public int reverse(int x) {
        int sign = 1;
        int result = 0;

        if (x < 0) {
            x *= -1;
            sign *= -1;
        }

        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        return result * sign;
    }
}
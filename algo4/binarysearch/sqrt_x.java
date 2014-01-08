
public class sqrt_x {
    /**
     * 46341 = Math.floor(2^31 - 1)
     * 
     */
    public static final int MAX_INT_SQRT = 46340;

    public static int sqrt(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x should never be negative!");
        }
        if (x < 1) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }

        int mid = x / 2;

        while (mid * mid > x || mid > MAX_INT_SQRT) {
            mid = (mid + x / mid) / 2;
        }

        return mid;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(10));
    }
}
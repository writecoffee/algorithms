public class sqrt_x {
    /**
     * Note that the goal is not to find the exact square root r but to find the floor(r).
     * So we terminate the loop when narrowing down the range to 1. A necessary testing case
     * for this is let x = 2.
     * 
     * Notice that we calculate the matching target to be x / mid so as to avoid data overflow.
     */
    public int sqrt(int x) {
        if (x < 2) {
            return x;
        }

        int low = 0;
        int high = x;

        while (high > low + 1) {
            int mid = low + (high - low) / 2;
            int div = x / mid;

            if (mid == div) {
                return mid;
            } else if (mid < div) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
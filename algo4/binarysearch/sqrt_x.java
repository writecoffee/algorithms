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

        int l = 1;
        int r = x;

        /**
         * Here we need the while loop terminates, if a^2 is slightly smaller than x and b^2
         * is slightly larger than x, we will return a as square root. An apparent test case
         * for this is let x = 2.
         */
        while (r > l + 1) {
            /**
             * Here we can come with test x = 2147483647 to let (l + r) overflow.
             */
            int a = l + (r - l) / 2;
            int b = x / a;

            if (a == b) {
                return a;
            } else if (a < b) {
                l = a;
                r = b;
            } else {
                l = b;
                r = a;
            }
        }

        return l;
    }
}
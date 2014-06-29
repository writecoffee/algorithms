/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/sqrtx/}
 * 
 */
public class math_sqrt_x {
    /**
     * Note that the goal is not to find the exact square root r but to find the floor(r).
     * So we terminate the loop when narrowing down the range to 1. A necessary testing case
     * for this is let x = 2.
     * 
     * Notice that we calculate the matching target to be x / mid so as to avoid data overflow.
     * 
     */
    public int sqrt(int x) {
        int l = 1, r = x;

        while (l < r - 1) {
            int a = l + (r - l) / 2, b = x / a;

            if (a == b) {
                return a;
            } else {
                l = Math.min(a, b);
                r = Math.max(a, b);
            }
        }

        return x == 0 ? 0 : l;
    }

    public int sqrt2(int x) {
        int l = 1, r = x;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if ((long) mid * mid > Integer.MAX_VALUE) {
                r = mid - 1;
            } else if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return x == 0 ? 0 : ((long) l * l > x ? l - 1 : l);
    }
}
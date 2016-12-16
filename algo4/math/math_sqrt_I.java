/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/sqrtx/}
 *
 */
public class math_sqrt_I {
    /**
     * Note that the goal is not to find the exact square root r but to find the floor(r).
     * So we terminate the loop when narrowing down the range to 1. A necessary testing case
     * for this is let x = 2.
     *
     * Notice that we calculate the matching target to be x / mid so as to avoid data overflow.
     *
     */
    public int sqrt(int x)
    {
        long start = 1, end = x;

        while (start + 1 < end) {
            long mid = start + ((end - start) >>> 2);

            if (mid * mid <= x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }

        return (int) start;
    }

    public float sqrt(float n)
    {
        float l = 0f;
        float r = n;

        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return 0;
        } else if (n < 1) {
            return 1 / sqrt(1 / n);
        }

        while (l < r) {
            float mid = (l + r) / 2;
            float mid2 = n / mid;

            if (mid == mid2) {
                return mid;
            } else {
                l = Math.min(mid, mid2);
                r = Math.max(mid, mid2);
            }
        }

        return l;
    }
}

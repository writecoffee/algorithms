package gmax;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has
 * the largest product = 6.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/maximum-product-subarray/}
 *
 */
public class dp_gmax_maximum_sub_array_product
{
    /**
     * Besides keeping track of the largest product, we also need to keep track
     * of the smallest product. Why? The smallest product, which is the largest
     * in the negative sense could become the maximum when being multiplied by a
     * negative number.
     *
     * Let us denote that:
     *
     * f(k) = Largest product subarray, from index 0 up to k. Similarly,
     *
     * g(k) = Smallest product subarray, from index 0 up to k.
     *
     * Then,
     *
     * f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
     *
     * g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
     *
     * There we have a dynamic programming formula. Using two arrays of size n,
     * we could deduce the final answer as f(n-1). Since we only need to access
     * its previous elements at each step, two variables are sufficient.
     */
    public int maxProduct(int[] nums)
    {
        int n = nums.length;
        int[] dp1 = new int[n], dp2 = new int[n];
        dp1[0] = nums[0];
        dp2[0] = nums[0];

        for (int i = 1; i < n; ++i) {
            dp1[i] = Math.max(dp2[i - 1] * nums[i], Math.max(dp1[i - 1] * nums[i], nums[i]));
            dp2[i] = Math.min(dp2[i - 1] * nums[i], Math.min(dp1[i - 1] * nums[i], nums[i]));
        }

        int gMax = nums[0];
        for (int i = 1; i < n; ++i) {
            gMax = Math.max(gMax, dp1[i]);
        }

        return gMax;
    }

    public int maxProductOptimized(int[] nums)
    {
        int n = nums.length, lMin = nums[0], lMax = nums[0], gMax = nums[0];

        for (int i = 1; i < n; ++i) {
            int preLMin = lMin;
            lMin = Math.min(lMax * nums[i], Math.min(lMin * nums[i], nums[i]));
            lMax = Math.max(preLMin * nums[i], Math.max(lMax * nums[i], nums[i]));
            gMax = Math.max(gMax, lMax);
        }

        return gMax;
    }
}

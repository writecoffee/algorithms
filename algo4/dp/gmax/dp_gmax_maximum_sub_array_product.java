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
 *                {@linkplain http://www.lintcode.com/en/problem/maximum-product-subarray/}
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

        int preMin = nums[0];
        int preMax = nums[0];
        int result = nums[0];

        for (int i = 1; i < n; i++) {
            int tPreMin = preMin;
            preMin = Math.min(preMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            preMax = Math.max(preMax * nums[i], Math.max(tPreMin * nums[i], nums[i]));
            result = Math.max(preMax, result);
        }

        return result;
    }
}

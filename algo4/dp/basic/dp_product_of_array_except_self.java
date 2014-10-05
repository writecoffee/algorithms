package basic;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 *
 * Solve it without division and in O(n).
 *
 * For example, given [1,2,3,4], return [24,12,8,6].
 *
 * Follow up:
 *
 * Could you solve it with constant space complexity? (Note: The output array
 * does not count as extra space for the purpose of space complexity analysis.)
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/product-of-array-except-self/}
 *
 */
public class dp_product_of_array_except_self
{
    public int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;

        if (n == 0) {
            return new int[0];
        } else if (n == 1) {
            return new int[1];
        }

        int[] ldp = new int[n], rdp = new int[n];

        ldp[0] = nums[0];
        rdp[n - 1] = nums[n - 1];
        for (int i = 1; i < n; ++i) {
            ldp[i] = ldp[i - 1] * nums[i];
            rdp[n - 1 - i] = rdp[n - i] * nums[n - 1 - i];
        }

        int[] result = new int[n];
        result[0] = rdp[1];
        for (int i = 1; i < n - 1; ++i) {
            result[i] = ldp[i - 1] * rdp[i + 1];
        }
        result[n - 1] = ldp[n - 2];

        return result;
    }
}

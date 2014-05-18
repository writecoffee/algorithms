package gmax;

/**
 * * Maximum Two Subarray Sum
 *
 * Given an array with integers.
 *
 * Find two non-overlapping subarrays A and B, which SUM(A) + SUM(B) is the
 * largest.
 *
 * Return the largest sum.
 *
 * Example
 *
 * For [1, 2, -3, 1], return 4
 *
 * The subarray should contain at least one number
 *
 * O(n) time and O(n) space.
 *
 * [Source]     - Unknown
 * [Difficulty] - Medium
 *
 */
public class dp_gmax_two_subarrays_sum
{
    public int maxTwoSubArrays(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxEndingHere = nums[0];
        int n = nums.length;
        int[] maxFromLeft = new int[n];

        for (int i = 1; i < n; i++) {
            int num = nums[i];
            maxEndingHere = Math.max(maxEndingHere + num, num);
            maxFromLeft[i] = Math.max(maxEndingHere, maxFromLeft[i - 1]);
        }

        int maxSoFar = nums[n - 1];
        maxEndingHere = nums[n - 1];
        int sum = maxSoFar + maxFromLeft[n - 2];
        for (int i = n - 2; i > 0; i--) {
            int num = nums[i];
            maxEndingHere = Math.max(maxEndingHere + num, num);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            sum = Math.max(sum, maxSoFar + maxFromLeft[i - 1]);
        }

        return sum;
    }
}

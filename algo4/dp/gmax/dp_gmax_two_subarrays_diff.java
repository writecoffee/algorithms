package gmax;

/**
 * Maximum Subarray Difference
 *
 * Given an array with integers.
 *
 * Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the
 * largest.
 *
 * Return the largest difference.
 *
 * Example
 *
 * For [1, 2, -3, 1], return 6
 *
 * The subarray should contain at least one number
 *
 * O(n) time and O(n) space.
 *
 * [Source]     - Unknown
 * [Difficulty] - Medium
 *
 */
public class dp_gmax_two_subarrays_diff
{
    /**
     * | 0   i | i + 1    n - 1 |
     *   A             B
     *
     * We need to find an index to separate input array into two, where
     *
     * -- i = [1 ~ n - 2]
     * -- A denotes left half of the array and B denotes the right half of the array.
     *
     * So the objective becomes finding max{subarraySum(A) - subarraySum(B), subarraySum(B) - subarraySum(A)}
     *
     * We will need two arrays
     * (1) maxSoFar[i] = biggest subarray sum of array [0, i]
     * (2) minSoFar[i] = smallest subarray sum of array [0, i]
     *
     * Here maxSoFar[i] and minSoFar[i] are what required computing for A in above objective. 
     *
     */
    public int maxDiffSubArrays(int[] nums)
    {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int maxEndingHere = nums[0];
        int[] maxSoFarFromLeft = new int[n];
        maxSoFarFromLeft[0] = nums[0];
        int minEndingHere = nums[0];
        int[] minSoFarFromLeft = new int[n];
        minSoFarFromLeft[0] = nums[0];

        for (int i = 1; i < n - 1; i++) {
            int c = nums[i];
            maxEndingHere = Math.max(maxEndingHere + c, c);
            maxSoFarFromLeft[i] = Math.max(maxSoFarFromLeft[i - 1], maxEndingHere);
            minEndingHere = Math.min(minEndingHere + c, c);
            minSoFarFromLeft[i] = Math.min(minSoFarFromLeft[i - 1], minEndingHere);
        }

        maxEndingHere = nums[n - 1];
        minEndingHere = nums[n - 1];
        int minSoFarFromRight = nums[n - 1];
        int maxSoFarFromRight = nums[n - 1];
        int maxDiff = Math.max(nums[n - 1] - minSoFarFromLeft[n - 2], maxSoFarFromLeft[n - 2] - nums[n - 1]);
        for (int i = n - 2; i > 0; i--) {
            int c = nums[i];
            maxEndingHere = Math.max(maxEndingHere + c, c);
            minEndingHere = Math.min(minEndingHere + c, c);
            minSoFarFromRight = Math.min(minEndingHere, minSoFarFromRight);
            maxSoFarFromRight = Math.max(maxEndingHere, maxSoFarFromRight);
            maxDiff = Math.max(maxDiff, maxSoFarFromRight - minSoFarFromLeft[i - 1]);
            maxDiff = Math.max(maxDiff, maxSoFarFromLeft[i - 1] - minSoFarFromRight);
        }

        return maxDiff;
    }
}

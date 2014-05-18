package gmax;

/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous
 * sub-array [4,−1,2,1] has the largest sum = 6.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/maximum-subarray/}
 *                {@linkplain http://www.lintcode.com/en/problem/maximum-subarray/}
 *
 */
public class dp_gmax_maximum_continuous_subarray_sum
{
    /**
     * Let f(k) = Maximum subarray sum ending at index k.
     *
     * Then f(k) = max(f(k - 1) + A[k], A[k])
     *
     * Using an array of size n, we could deduce the final answer by as f(n - 1),
     * with the initial state of f(0) = A[0].
     * 
     * Since we only need to access its previous element at each step, two variables
     * are sufficient.
     * 
     * Notice the difference between the two: maxEndingHere and maxSoFar; the former is the
     * maximum sum of subarray that must end at index k, while the latter is the
     * global maximum subarray sum.
     *
     */
    public int maxSubArray(int[] nums)
    {
        int n = nums.length;
        int maxEndingHere = nums[0];
        int maxSoFar = maxEndingHere;

        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}

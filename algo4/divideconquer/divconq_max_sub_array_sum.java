/**
 * Find the contiguous subarray within an array (containing at least one number)
 * which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray
 * [4,−1,2,1] has the largest sum = 6.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/maximum-subarray/}
 *
 */
public class divconq_max_sub_array_sum
{
    public int maxSubArray(int[] nums)
    {
        return recurse(nums, 0, nums.length - 1);
    }

    /**
     * O(n log n) runtime, O(log n) stack space – Divide and Conquer: Assume we
     * partition the array A into two smaller arrays S and T at the middle
     * index, M. Then, S = A1 … AM-1, and T = AM+1 … AN.
     *
     * The contiguous subarray that has the largest sum could either:
     *
     * i. Contain the middle element:
     *
     * a. The largest sum is the maximum suffix sum of S + AM + the maximum
     * prefix sum of T.
     *
     * ii. Does not contain the middle element:
     *
     * a. The largest sum is in S, which we could apply the same algorithm to S.
     *
     * b. The largest sum is in T, which we could apply the same algorithm to T.
     *
     * The time complexity is O(n log n).
     */
    private int recurse(int[] nums, int l, int r)
    {
        if (l > r) {
            return Integer.MIN_VALUE;
        }

        int mid = (l + r) / 2;

        int lMax = recurse(nums, l, mid - 1);
        int rMax = recurse(nums, mid + 1, r);

        int midOffLeftMax = 0, lSum = 0;
        for (int i = mid - 1; i >= l; --i) {
            lSum += nums[i];
            if (lSum > midOffLeftMax) {
                midOffLeftMax = lSum;
            }
        }

        int midOffRightMax = 0, rSum = 0;
        for (int j = mid + 1; j <= r; ++j) {
            rSum += nums[j];
            if (rSum > midOffRightMax) {
                midOffRightMax = rSum;
            }
        }

        return Math.max(Math.max(midOffLeftMax + nums[mid] + midOffRightMax, lMax), rMax);
    }
}

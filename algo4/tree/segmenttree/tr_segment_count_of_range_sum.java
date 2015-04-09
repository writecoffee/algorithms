package segmenttree;

/**
 * Given an integer array nums, return the number of range sums that lie in
 * [lower, upper] inclusive. Range sum S(i, j) is defined as the sum of the
 * elements in nums between indices i and j (i ≤ j), inclusive.
 *
 * Note:
 *
 * A naive algorithm of O(n2) is trivial. You MUST do better than that.
 *
 * Example:
 *
 * Given nums = [-2, 5, -1], lower = -2, upper = 2,
 *
 * Return 3.
 *
 * The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are:
 * -2, -1, 2.
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/count-of-range-sum/}
 *
 */
public class tr_segment_count_of_range_sum
{
    public int countRangeSum(int[] nums, int lower, int upper)
    {
        int n = nums.length;
        long[] accSum = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            accSum[i] = accSum[i - 1] + nums[i - 1];
        }

        return splitWhileMergeCount(accSum, lower, upper, 0, n + 1);
    }

    private int splitWhileMergeCount(long[] accSum, int lower, int upper, int start, int end)
    {
        int size = end - start;

        if (size <= 0) {
            return 0;
        } else if (size == 1) {
            // it will duplicate count for the case sum(nums[0.. i]) if we do
            // check lower <= accSum[start] <= upper here.
            return 0;
        }

        int mid = start + (size >>> 1);
        int lcount = splitWhileMergeCount(accSum, lower, upper, start, mid);
        int rcount = splitWhileMergeCount(accSum, lower, upper, mid, end);

        return lcount + rcount + merge(accSum, lower, upper, start, mid, end);
    }

    private int merge(long[] accSum, int lower, int upper, int start, int mid, int end)
    {
        int count = doCount(start, mid, end, lower, upper, accSum);

        long[] t = new long[end - start];
        int l = start;
        int r = mid;
        int ti = 0;

        while (l < mid && r < end) {
            if (accSum[l] < accSum[r]) {
                t[ti] = accSum[l];
                ti++;
                l++;
            } else {
                t[ti] = accSum[r];
                r++;
                ti++;
            }
        }

        while (l < mid) {
            t[ti] = accSum[l];
            ti++;
            l++;
        }

        while (r < end) {
            t[ti] = accSum[r];
            ti++;
            r++;
        }

        for (int i = start; i < end; i++) {
            accSum[i] = t[i - start];
        }

        return count;
    }

    private int doCount(int start, int mid, int end, int lower, int upper, long[] accSum)
    {
        int j = mid;
        int k = mid;
        int count = 0;

        for (int i = start; i < mid; i++) {
            for (; j < end && accSum[j] - accSum[i] < lower; j++) {
            }

            k = j;
            for (; k < end && accSum[k] - accSum[i] <= upper; k++) {
            }

            count += (k - j);
        }

        return count;
    }
}

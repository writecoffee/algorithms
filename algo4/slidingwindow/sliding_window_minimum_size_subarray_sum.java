/**
 *
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a subarray of which the sum ≥ s. If there isn't one, return
 * 0 instead.
 *
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has
 * the minimal length under the problem constraint.
 *
 * click to show more practice.
 *
 * More practice: If you have figured out the O(n) solution, try coding another
 * solution of which the time complexity is O(n log n).
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/minimum-size-subarray-sum/}
 *
 */
public class sliding_window_minimum_size_subarray_sum
{
    public int minSubArrayLen(int s, int[] nums)
    {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int gMin = n + 1;

        for (int l = 0, r = 1, lSum = nums[0]; lSum >= s || r < n;) {
            if (lSum < 0) {
                lSum = 0;
                l = r;
            } else if (lSum >= s) {
                gMin = Math.min(gMin, r - l);
                lSum -= nums[l];
                l++;
            } else {
                lSum += nums[r];
                r++;
            }
        }

        return gMin > n ? 0 : gMin;
    }
}

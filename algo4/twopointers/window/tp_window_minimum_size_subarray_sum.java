package window;

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
 *                {@linkplain http://www.lintcode.com/en/problem/minimum-size-subarray-sum/}
 *
 */
public class tp_window_minimum_size_subarray_sum
{
    public int minimumSize(int[] nums, int s)
    {
        int n = nums.length,
            sum = 0,
            result = Integer.MAX_VALUE;

        for (int i = 0, j = 0; i < n; i++) {
            for (; j < n && sum < s; j++) {
                sum += nums[j];
            }

            if (sum >= s) {
                result = Math.min(result, j - i);
            }

            sum -= nums[i];
        }

        if (result == Integer.MAX_VALUE) {
            return -1;
        } else {
            return result;
        }
    }
}

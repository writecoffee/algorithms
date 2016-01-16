package memorization_search;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.
 *
 * For example,
 *
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 *
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is
 * 4. Note that there may be more than one LIS combination, it is only necessary
 * for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/longest-increasing-subsequence/}
 * [Difficulty] - Medium
 *
 */
public class dp_ms_longest_increasing_subsequence
{
    public int lengthOfLIS(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int result = 1;

        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}

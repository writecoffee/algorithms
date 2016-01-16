package gmax;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/house-robber/}
 *
 */
public class dp_gmax_house_robber_II
{
    public int rob(int[] nums)
    {
        int n = nums.length;
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < n + 2; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 2]);
        }

        return dp[n + 1];
    }
}

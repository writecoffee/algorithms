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
 * Note: This is an extension of House Robber.
 *
 * After robbing those houses on that street, the thief has found himself a new
 * place for his thief so that he will not get too much attention. This time,
 * all houses at this place are arranged in a circle. That means the first house
 * is the neighbor of the last one. Meanwhile, the security system for these
 * houses remain the same as for those in the previous street.
 *
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/house-robber-ii/}
 *
 */
public class dp_gmax_house_robber_I
{
    public int rob(int[] nums)
    {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        int[] dp1 = new int[3], dp2 = new int[3];

        dp1[2] = nums[0];

        for (int i = 3; i < n + 1; ++i) {
            dp1[i % 3] = Math.max(dp1[(i - 1) % 3], dp1[(i - 2) % 3] + nums[i - 2]);
            dp2[i % 3] = Math.max(dp2[(i - 1) % 3], dp2[(i - 2) % 3] + nums[i - 2]);
        }

        dp2[(n + 1) % 3] = Math.max(dp2[n % 3], dp2[(n - 1) % 3] + nums[n - 1]);

        return Math.max(dp2[(n + 1) % 3], dp1[n % 3]);
    }
}

package sums;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You
 * may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/3sum-closest/}
 *
 */
public class tp_3sum_closest
{
    public int threeSumClosest(int[] num, int target)
    {
        int n = num.length;
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];

        for (int k = 0; k < n - 2; ++k) {
            int i = k + 1, j = n - 1;

            while (i < j) {
                int tsum = num[i] + num[j] + num[k];

                if (tsum == target) {
                    return tsum;
                } else if (tsum < target) {
                    i++;
                } else {
                    j--;
                }

                result = Math.abs(target - tsum) < Math.abs(target - result) ? tsum : result;
            }
        }

        return result;
    }
}

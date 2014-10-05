package sums;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤
 * c) The solution set must not contain duplicate triplets.
 *
 * For example, given array S = {-1 0 1 2 -1 -4},
 *
 * A solution set is:
 *
 * (-1, 0, 1)
 *
 * (-1, -1, 2)
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/3sum/}
 * [Difficulty] - Medium
 *
 */
public class tp_3sum
{
    public List<List<Integer>> threeSum(int[] num)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(num);
        int n = num.length;

        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int l = i + 1, r = n - 1;
            int target = 0 - num[i];

            while (l < r) {
                int tsum = num[l] + num[r];

                if (tsum == target) {
                    result.add(Arrays.asList(new Integer[] { num[i], num[l], num[r] }));

                    l++;
                    r--;
                    while (l < r && num[l] == num[l - 1]) {
                        l++;
                    }

                } else if (tsum < target) {
                    l++;
                } else if (tsum > target) {
                    r--;
                }
            }
        }

        return result;
    }
}

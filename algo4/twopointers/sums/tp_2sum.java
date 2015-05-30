package sums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 *
 * return [0, 1].
 *
 * UPDATE (2016/2/13):
 *
 * The return format had been changed to zero-based indices. Please read the
 * above updated description carefully.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/two-sum/}
 * [Difficulty] - Easy
 *
 */
public class tp_2sum
{
    private class Pair
    {
        private int val;
        private int index;

        private Pair(int _val, int _index)
        {
            val = _val;
            index = _index;
        }
    }

    public int[] tpTwoSum(int[] numbers, int target)
    {
        int n = numbers.length;
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; ++i) {
            pairs[i] = new Pair(numbers[i], i);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.val - b.val;
            }
        });

        int i = 0, j = n - 1;
        while (i < j) {
            int tsum = pairs[i].val + pairs[j].val;

            if (tsum == target) {
                return new int[] { Math.min(pairs[i].index + 1, pairs[j].index + 1),
                                   Math.max(pairs[i].index + 1, pairs[j].index + 1) };

            } else if (tsum < target) {
                i++;
            } else {
                j--;
            }
        }

        return null;
    }

    public int[] twoSum(int[] numbers, int target)
    {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int n = numbers.length;

        for (int i = 0; i < n; ++i) {
            int other = target - numbers[i];

            if (h.containsKey(other) && h.get(other) != i + 1) {
                return new int[] { Math.min(i + 1, h.get(other)),
                                   Math.max(i + 1, h.get(other)) };
            } else {
                h.put(numbers[i], i + 1);
            }
        }

        return null;
    }
}

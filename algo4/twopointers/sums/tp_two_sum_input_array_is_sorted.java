package sums;

/**
 * Given an array of integers that is already sorted in ascending order, find
 * two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 *
 * Output: index1=1, index2=2
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/}
 * [Tag]        - $binary-search$
 *
 */
public class tp_two_sum_input_array_is_sorted
{
    public int[] twoSumOptimized(int[] numbers, int target)
    {
        int n = numbers.length, i = 0, j = n - 1;

        while (i < j) {
            int lVal = numbers[i], rVal = numbers[j], sum = lVal + rVal;

            if (sum == target) {
                return new int[] { i + 1, j + 1 };
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }

        return new int[] { -1, -1 };
    }

    public int[] twoSum(int[] numbers, int target)
    {
        int n = numbers.length;

        for (int i = 0; i < n; ++i) {
            int l = i + 1, r = n - 1, other = target - numbers[i];

            while (l <= r) {
                int mid = (l + r) / 2, mVal = numbers[mid];

                if (mVal == other) {
                    return new int[] { i + 1, mid + 1 };
                } else if (mVal > other) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return new int[] { -1, -1 };
    }
}

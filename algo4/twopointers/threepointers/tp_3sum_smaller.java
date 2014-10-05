package threepointers;

import java.util.Arrays;

/**
 * Given an array of n integers nums and a target, find the number of index triplets
 * i, j, k with 0 <= i < j < k < n that satisfy the condition
 * nums[i] + nums[j] + nums[k] < target.
 *
 * For example, given nums = [-2, 0, 1, 3], and target = 2.
 *
 * Return 2. Because there are two triplets which sums are less than 2:
 *
 * [-2, 0, 1]
 * [-2, 0, 3]
 *
 * Follow up:
 *
 * Could you solve it in O(n2) runtime?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/3sum-smaller/}
 * [Difficulty] - Medium
 *
 */
public class tp_3sum_smaller
{
    /**
     * After sorting, if i, j, k is a valid triple, then i, j-1, k, ..., i, i+1, k
     * are also valid triples. No need to count them one by one.
     */
    public int threeSumSmaller(int[] nums, int target)
    {
        int n = nums.length, result = 0;
        Arrays.sort(nums);

        for (int k = 2; k < n; k++) {
            int boundary = target - nums[k];

            for (int i = 0, j = k - 1; i < j; ) {
                int lval = nums[i], rval = nums[j];

                if (lval + rval < boundary) {
                    result += j - i;
                    i++;
                } else {
                    j--;
                }
            }
        }

        return result;
    }
}

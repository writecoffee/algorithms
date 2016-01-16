package gmax;

import java.util.ArrayList;

/**
 * Given an integer array, find a continuous subarray where the sum of numbers
 * is the biggest. Your code should return the index of the first number and the
 * index of the last number. (If their are duplicate answer, return anyone)
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Give [-3, 1, 3, -3, 4], return [1,4].
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/continuous-subarray-sum/}
 * [Difficulty] - Medium
 *
 */
public class dp_gmax_maximum_continuous_subarray_sum_indices
{
    public ArrayList<Integer> continuousSubarraySum(int[] A)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int l = 0;
        int rl = 0;
        int rr = 0;
        int gSum = Integer.MIN_VALUE;
        int n = A.length;
        int lSum = 0;

        for (int i = 0; i < n; i++) {
            if (lSum < 0) {
                lSum = 0;
                l = i;
            }

            lSum += A[i];

            if (lSum > gSum) {
                gSum = lSum;
                rr = i;
                rl = l;
            }
        }

        result.add(rl);
        result.add(rr);
        return result;
    }
}

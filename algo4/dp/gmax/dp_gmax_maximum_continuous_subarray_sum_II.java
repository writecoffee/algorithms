package gmax;

import java.util.ArrayList;

/**
 * Given an integer array, find a continuous rotate subarray where the sum of
 * numbers is the biggest. Your code should return the index of the first number
 * and the index of the last number. (If their are duplicate answer, return
 * anyone. The answer can be rorate array or non- rorate array)
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Give [3, 1, -100, -3, 4], return [4,1].
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/continuous-subarray-sum-ii/}
 * [Difficulty] - Medium
 *
 */
public class dp_gmax_maximum_continuous_subarray_sum_II
{
    public ArrayList<Integer> continuousSubarraySumII(int[] A)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int n = A.length;
        int lSum = 0;
        int gSum = Integer.MAX_VALUE;
        int l = 0, rl = 0, rr = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];

            if (lSum > 0) {
                l = i;
                lSum = 0;
            }

            lSum += A[i];

            if (lSum < gSum) {
                gSum = lSum;
                rl = l;
                rr = i;
            }
        }

        /*
         * If all elements are < 0, then the largest negative number in the
         * array will be the answer.
         */
        if (rl != 0 && rr != n - 1) {
            gSum = sum - gSum;

            int t = rr;
            rr = (rl - 1 + n) % n;
            rl = (t + 1) % n;
        }

        l = 0;
        lSum = 0;
        for (int i = 0; i < n; i++) {
            if (lSum < 0) {
                l = i;
                lSum = 0;
            }

            lSum += A[i];

            if (lSum > gSum) {
                gSum = lSum;
                rl = l;
                rr = i;
            }
        }

        result.add(rl);
        result.add(rr);
        return result;
    }
}

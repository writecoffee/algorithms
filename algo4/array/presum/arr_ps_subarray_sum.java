package presum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array, find a subarray where the sum of numbers is zero.
 * Your code should return the index of the first number and the index of the
 * last number.
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
 *
 * Note
 *
 * There is at least one subarray that it's sum equals to zero.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/subarray-sum/}
 * [Difficulty] - Easy
 *
 */
public class arr_ps_subarray_sum
{
    public ArrayList<Integer> subarraySum(int[] nums)
    {
        ArrayList<Integer> result = new ArrayList<>();

        int n = nums.length;
        int[] subSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            subSum[i + 1] = subSum[i] + nums[i];
        }

        Map<Integer, Integer> h = new HashMap<>();
        h.put(0, -1);

        for (int i = 1; i <= n; i++) {
            int sumToi = subSum[i];

            if (h.containsKey(sumToi)) {
                result.add(h.get(sumToi) + 1);
                result.add(i - 1);
                break;
            }

            h.put(sumToi, i - 1);
        }

        return result;
    }
}

package presum;

import java.util.HashMap;

/**
 * Given an array nums and a target value k, find the maximum length of a
 * subarray that sums to k. If there isn't one, return 0 instead.
 * 
 * Example 1:
 * 
 * Given nums = [1, -1, 5, -2, 3], k = 3,
 * 
 * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * 
 * Example 2:
 * 
 * Given nums = [-2, -1, 2, 1], k = 1,
 * 
 * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * 
 * Follow Up:
 * 
 * Can you do it in O(n) time?
 * 
 * [Source]     - {@linkplain https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/}
 * [Difficulty] - Easy
 *
 */
public class arr_ps_maximum_size_subarray_sum_equals_k
{
    public int maxSubArrayLen(int[] nums, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int gMax = 0;
        int sum = 0;

        /*
         * starting point, if k == 0, then just need to find the zero-sum valued
         * window.
         */
        map.put(0, -1);
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                int pi = map.get(sum - k);
                gMax = Math.max(i - pi, gMax);
            }

            map.putIfAbsent(sum, i);
        }

        return gMax;
    }
}

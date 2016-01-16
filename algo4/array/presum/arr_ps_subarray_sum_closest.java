package presum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an integer array, find a subarray with sum closest to zero. Return the
 * indexes of the first number and last number.
 *
 * Example
 *
 * Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
 *
 * Challenge O(nlogn) time
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/subarray-sum-closest/}
 * [Difficulty] - Medium
 *
 */
public class arr_ps_subarray_sum_closest
{
    public class Pair
    {
        int sum, i;

        Pair(int sum, int i) {
            this.sum = sum;
            this.i = i;
        }
    }

    public ArrayList<Integer> subarraySumClosest(int[] nums)
    {
        ArrayList<Integer> result = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            result.add(0);
            result.add(0);
            return result;
        }

        Pair[] subSum = new Pair[n + 1];
        subSum[0] = new Pair(0, -1);

        for (int i = 0; i < n; i++) {
            subSum[i + 1] = new Pair(subSum[i].sum + nums[i], i);
        }

        Arrays.sort(subSum, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            int d = subSum[i].sum - subSum[i - 1].sum;

            if (d < minDiff) {
                result.clear();
                result.add(Math.min(subSum[i].i, subSum[i - 1].i) + 1);
                result.add(Math.max(subSum[i].i, subSum[i - 1].i));
                minDiff = d;
            }
        }

        return result;
    }
}

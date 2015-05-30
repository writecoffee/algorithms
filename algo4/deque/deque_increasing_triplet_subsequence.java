package deque;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 *
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Examples:
 * Given [1, 2, 3, 4, 5],
 * return true.
 *
 * Given [5, 4, 3, 2, 1],
 * return false.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/increasing-triplet-subsequence/}
 *
 */
public class deque_increasing_triplet_subsequence
{
    public boolean increasingTriplet(int[] nums)
    {
        List<Integer> q = new ArrayList<>();
        q.add(Integer.MAX_VALUE);
        q.add(Integer.MAX_VALUE);

        for (int num : nums) {
            if (num <= q.get(0)) {
                q.set(0, num);
            } else if (num <= q.get(1)) {
                q.set(1, num);
            } else {
                return true;
            }
        }

        return false;
    }
}

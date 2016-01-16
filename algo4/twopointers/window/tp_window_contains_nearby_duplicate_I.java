package window;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there there are
 * two distinct indices i and j in the array such that nums[i] = nums[j] and the
 * difference between i and j is at most k.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/contains-duplicate-ii/}
 *
 */
public class tp_window_contains_nearby_duplicate_I
{
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        if (k == 0) {
            return false;
        }

        int[] backPointers = new int[k];
        Set<Integer> visited = new HashSet<Integer>();

        for (int i = 0; i < n; ++i) {
            int c = nums[i];

            if (!visited.add(c)) {
                return true;
            }

            if (i >= k) {
                int toBePurged = backPointers[i % k];
                visited.remove(toBePurged);
            }

            backPointers[i % k] = c;
        }

        return false;
    }
}

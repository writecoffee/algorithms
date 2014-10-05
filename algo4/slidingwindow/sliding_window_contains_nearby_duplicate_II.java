import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/contains-duplicate-iii/}
 * [Difficulty] - Medium
 */
public class sliding_window_contains_nearby_duplicate_II
{
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
    {
        int n = nums.length;

        if (k <= 0) {
            return false;
        }

        for (int i = 0; i < n; ++i) {
            int c = nums[i];

            for (int j = i - 1; j >= Math.max(0, i - k); --j) {
                int pre = nums[j], diff = Math.abs(pre - c);

                if (diff <= t) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsNearbyAlmostDuplicateOptimized(int[] nums, int k, int t)
    {
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(Long.valueOf(nums[i - k - 1]));
            }

            long upperBound = (long) nums[i] + t,
                 lowerBound = (long) nums[i] - t;

            Long peeking = set.lower(upperBound + 1);

            if (peeking != null && peeking >= lowerBound) {
                return true;
            }

            set.add(Long.valueOf(nums[i]));
        }

        return false;
    }
}

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 *
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 *
 * return [3, 4].
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/search-for-a-range/}
 * [Tag]        - $range$
 *
 */
public class bs_search_for_a_range
{
    public int[] searchRange(int[] nums, int target)
    {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int rl = -1;
        int rr = -1;

        while (l + 1 < r) {
            int mid = l + ((r - l) >>> 1);
            int mval = nums[mid];

            if (mval < target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (nums[l] == target) {
            rl = l;
        } else if (nums[r] == target) {
            rl = r;
        }

        l = 0;
        r = n - 1;

        while (l + 1 < r) {
            int mid = l + ((r - l) >>> 1);
            int mval = nums[mid];

            if (mval <= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (nums[r] == target) {
            rr = r;
        } else if (nums[l] == target) {
            rr = l;
        }

        return new int[] { rl, rr };
    }
}
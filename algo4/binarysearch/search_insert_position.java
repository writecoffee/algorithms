/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 *
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/search-insert-position/}
 * [Difficulty] - Medium
 *
 */
public class search_insert_position
{
    public int searchInsert(int[] nums, int target)
    {
        int n = nums.length;
        int l = 0;
        int r = n - 1;

        while (l + 1 < r) {
            int mid = l + ((r - l) >>> 1);
            int mval = nums[mid];

            if (mval >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (nums[l] >= target) {
            return 0;
        } else if (nums[r] < target) {
            return r + 1;
        } else {
            return r;
        }
    }
}
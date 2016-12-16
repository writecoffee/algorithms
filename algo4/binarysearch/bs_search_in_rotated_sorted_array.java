/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index,
 * otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/search-in-rotated-sorted-array/}
 * [Difficulty] - Hard
 *
 */
public class bs_search_in_rotated_sorted_array
{
    public int search(int[] nums, int target)
    {
        int n = nums.length;

        for (int l = 0, r = n - 1; l + 1 < r;) {
            int lval = nums[l];
            int rval = nums[r];
            int mid = l + ((r - l) >>> 1);
            int mval = nums[mid];

            if (mval == target) {
                return mid;
            } else if (lval < mval) {
                if (target >= lval && target < mval) {
                    r = mid;
                } else {
                    l = mid;
                }
            } else {
                if (target > mval && target <= rval) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }

        if (nums[0] == target) {
            return 0;
        } else if (nums[n - 1] == target) {
            return n - 1;
        } else {
            return -1;
        }
    }
}
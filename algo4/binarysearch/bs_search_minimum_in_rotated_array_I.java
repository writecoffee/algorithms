/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-i/}
 *
 */
public class bs_search_minimum_in_rotated_array_I
{
    /**
     * (1) There is no rotation.
     * (2) start point is on the left.
     * (3) start point is on the right.
     * 
     */
    public int findMin(int[] nums)
    {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int target = nums[r];

        while (l + 1 < r) {
            int mid = l + ((r - l) >>> 1);
            int mval = nums[mid];

            if (mval >= target) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return Math.min(nums[l], nums[r]);
    }
}

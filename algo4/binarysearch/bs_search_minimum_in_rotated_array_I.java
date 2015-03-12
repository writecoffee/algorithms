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
 * [Source]     - {@linkplain https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/}
 *
 */
public class bs_search_minimum_in_rotated_array_I
{
    public int findMin(int[] nums)
    {
        int l = 0, r = nums.length - 1;

        while (l < r && nums[l] > nums[r]) {
            int mid = (l + r) / 2, midVal = nums[mid];

            if (midVal > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }
}

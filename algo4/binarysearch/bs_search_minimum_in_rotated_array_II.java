/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 *
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/}
 *
 */
public class bs_search_minimum_in_rotated_array_II
{
    public int findMin(int[] nums)
    {
        int l = 0, r = nums.length - 1, lVal = nums[l], rVal = nums[r];

        while (l < r && lVal >= rVal) {
            int mid = (l + r) / 2, midVal = nums[mid];

            if (midVal > rVal) {
                l = mid + 1;
            } else if (midVal < rVal) {
                r = mid;
            } else {
                l += 1;
            }

            lVal = nums[l];
            rVal = nums[r];
        }

        return nums[l];
    }
}

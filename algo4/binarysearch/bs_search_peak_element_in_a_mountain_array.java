/**
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return
 * its index.
 *
 * The array may contain multiple peaks, in that case return the index to any
 * one of the peaks is fine.
 *
 * You may imagine that num[-1] = num[n] = -∞.
 *
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function
 * should return the index number 2.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/find-peak-element/}
 *
 */
public class bs_search_peak_element_in_a_mountain_array
{
    public int findPeakElement(int[] nums)
    {
        int n = nums.length, l = 0, r = n - 1;

        while (l < r - 1) {
            int mid = (l + r) / 2, lVal = nums[mid - 1], rVal = nums[mid + 1], mVal = nums[mid];

            if (lVal < mVal && mVal > rVal) {
                return mid;
            } else if (lVal < mVal && mVal < rVal) {
                l = mid;
            } else {
                r = mid;
            }
        }

        if (l == r - 1 && nums[l] > nums[r]) {
            return l;
        } else if (l == r - 1) {
            return r;
        } else {
            return l;
        }
    }
}

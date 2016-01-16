/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/median-of-two-sorted-arrays/}
 *
 */
public class median_of_two_sorted_arrays
{
    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int m = nums1.length;
        int n = nums2.length;
        int mn = m + n;

        if (mn % 2 == 1) {
            return find(nums1, 0, nums2, 0, mn / 2 + 1);
        } else {
            return (find(nums1, 0, nums2, 0, mn / 2) + find(nums1, 0, nums2, 0, mn / 2 + 1)) * 0.5;
        }
    }

    private int find(int[] nums1, int i1, int[] nums2, int i2, int k)
    {
        if (i1 >= nums1.length) {
            return nums2[i2 + k - 1];
        }

        if (i2 >= nums2.length) {
            return nums1[i1 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[i1], nums2[i2]);
        }

        /*
         * We forward only one array at a time. If medium k / 2 exceed the length of one array,
         * we arbitrarily set the mid-value to be MAX such that we can force the other array to move
         * forward.
         *
         */
        int mid1 = i1 + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[i1 + k / 2 - 1];
        int mid2 = i2 + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[i2 + k / 2 - 1];

        if (mid1 >= mid2) {
            return find(nums1, i1, nums2, i2 + k / 2, k - k / 2);
        } else {
            return find(nums1, i1 + k / 2, nums2, i2, k - k / 2);
        }
    }
}

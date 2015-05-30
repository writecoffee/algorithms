import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] >
 * nums[2] < nums[3]....
 *
 * Example:
 *
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 *
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 *
 * You may assume all input has valid answer.
 *
 * Follow Up:
 *
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/wiggle-sort-ii/}
 * [Difficult]  - Medium
 *
 */
public class wiggle_sort_II
{
    public void wiggleSort(int[] nums)
    {
        Arrays.sort(nums);

        int n = nums.length;
        int modMask = n | 1;
        int[] result = new int[n];

        for (int i = 0; i < n / 2; i++) {
            int t = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = t;
        }

        for (int i = 0; i < n; i++) {
            result[(1 + 2 * i) % modMask] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i] = result[i];
        }
    }
}

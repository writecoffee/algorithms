/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <=
 * nums[1] >= nums[2] <= nums[3]....
 *
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6,
 * 2, 5, 3, 4].
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/wiggle-sort/}
 *
 */
public class wiggle_sort
{
    public void wiggleSort(int[] nums)
    {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            if ((i % 2) == 1 && nums[i] < nums[i - 1]) {
                swap(nums, i, i - 1);
            } else if ((i % 2) == 0 && nums[i] > nums[i - 1]) {
                swap(nums, i, i - 1);
            }
        }
    }

    private void swap(int[] nums, int i1, int i2)
    {
        int t = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = t;
    }
}

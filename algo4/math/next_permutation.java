/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 *
 * 3,2,1 → 1,2,3
 *
 * 1,1,5 → 1,5,1
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/next-permutation/}
 * [Difficulty] - Medium
 *
 */
public class next_permutation
{
    public void nextPermutation(int[] nums)
    {
        int n = nums.length;

        /*
         * Find the first element from right to left that break the ascending
         * trend.
         */
        int start = -1;
        for (int i = n - 2; i >= 0; i--) {
            int c = nums[i];
            int p = nums[i + 1];

            if (c >= p) {
                continue;
            } else {
                start = i;
                break;
            }
        }

        reverse(nums, start + 1, n - 1);

        /*
         * We already exhaust all the permutations.
         */
        if (start == -1) {
            return;
        }

        /*
         * Only one element on the right.
         */
        if (start + 1 == n - 1) {
            swap(nums, start, n - 1);
            return;
        }

        int swapVal = nums[start];
        int l = start + 1, r = n - 1;
        while (l + 1 < r) {
            int mid = l + ((r - l) >>> 1);
            int mval = nums[mid];

            if (mval > swapVal) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (nums[l] > swapVal) {
            swap(nums, start, l);
        } else if (nums[r] > swapVal) {
            swap(nums, start, r);
        }
    }

    private void reverse(int[] nums, int start, int end)
    {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] array, int i, int j)
    {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}

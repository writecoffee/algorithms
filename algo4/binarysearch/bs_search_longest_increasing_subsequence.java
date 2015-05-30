/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * For example,
 *
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 *
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for you
 * to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/longest-increasing-subsequence/}
 * [Difficulty] - Medium
 *
 */
public class bs_search_longest_increasing_subsequence
{
    public int lengthOfLIS(int[] nums)
    {
        int n = nums.length;
        int gMax = 0;
        int[] seq = new int[n];

        for (int num : nums) {
            int pos = findLargerThan(seq, gMax, num);
            seq[pos] = num;
            gMax = Math.max(gMax, pos + 1);
        }

        return gMax;
    }

    private int findLargerThan(int[] seq, int end, int num)
    {
        int l = 0;
        int r = end - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int midVal = seq[mid];

            if (midVal < num) {
                l = mid + 1;
            } else if (midVal > num) {
                r = mid - 1;
            } else {
                return mid;
            }
        }

        return l;
    }
}

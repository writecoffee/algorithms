/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * 
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * 
 * return [3, 4].
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/search-for-a-range/}
 * [Tag]        - $range$
 *
 */
public class bs_search_for_a_range
{
    public int[] searchRange(int[] array, int target)
    {
        int n = array.length;
        int l = lSearch(array, target, n, 0, n - 1);
        int r = rSearch(array, target, n, 0, n - 1);

        if (l <= r) {
            return new int[] { l, r };
        } else {
            return new int[] { -1, -1 };
        }
    }

    private int lSearch(int[] array, int target, int n, int l, int r)
    {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int rSearch(int[] array, int target, int n, int l, int r)
    {
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }
}
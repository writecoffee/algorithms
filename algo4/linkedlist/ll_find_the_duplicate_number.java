/**
 * Given an array nums containing n + 1 integers where each integer is between 1
 * and n (inclusive), prove that at least one duplicate number must exist.
 * Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 *
 * 1.  You must not modify the array (assume the array is read only).
 * 2.  You must use only constant, O(1) extra space.
 * 3.  Your runtime complexity should be less than O(n2).
 * 4.  There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/find-the-duplicate-number/}
 *
 */
public class ll_find_the_duplicate_number
{
    /**
     *              d
     * ----------------------------^
     *                           /   \       cycle diameter: r
     *                          |     |      meet-up point: x
     *                           \___/
     *
     * We have:
     *   (1) 2S = S + nr
     *   (2) d + x = S   => S = d + x
     *   (3) S = nr      => S = (n - 1) r + r
     *
     * Plug in (2) into (3), we get
     *
     *   d = (n - 1) r + (r - x)
     *
     * This approach essentially creates a graph out of the array (outgoing edge from each
     * array value to the index denoted by that array value). Then, we run Floyd's cycle
     * finding algorithm (tortoise and hare) to find the cycle (duplicate value in array).
     *
     */
    public int findDuplicate(int[] nums)
    {
        int p = nums[0], q = nums[nums[0]];

        while (p != q) {
            p = nums[p];
            q = nums[nums[q]];
        }

        int v = nums[0];
        p = nums[p];
        while (p != v) {
            p = nums[p];
            v = nums[v];
        }

        return p;
    }
}

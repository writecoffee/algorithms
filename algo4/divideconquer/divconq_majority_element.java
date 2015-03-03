/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/majority-element/}
 *
 */
public class divconq_majority_element
{
    /**
     * Runtime: O(n log n) — Divide and conquer: Divide the array into two
     * halves, then find the majority element A in the first half and the
     * majority element B in the second half. The global majority element must
     * either be A or B. If A == B, then it automatically becomes the global
     * majority element. If not, then both A and B are the candidates for the
     * majority element, and it is suffice to check the count of occurrences for
     * at most two candidates. The runtime complexity, T(n) = 2*T(n/2) + n = O(n
     * log n).
     */
    public int majorityElement(int[] nums)
    {
        return subMajority(nums, 0, nums.length - 1);
    }

    private int subMajority(int[] nums, int l, int r)
    {
        if (l == r) {
            return nums[l];
        }

        int mid = (l + r) / 2,
            lMaj = subMajority(nums, l, mid),
            rMaj = subMajority(nums, mid + 1, r);

        if (lMaj == rMaj) {
            return lMaj;
        }

        int lMajCount = 0, rMajCount = 0;
        for (int i = l; i <= r; ++i) {
            if (nums[i] == lMaj) {
                lMajCount++;
            } else if (nums[i] == rMaj) {
                rMajCount++;
            }
        }

        if (lMajCount > rMajCount) {
            return lMaj;
        } else {
            return rMaj;
        }
    }
}

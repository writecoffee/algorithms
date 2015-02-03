package bitvector;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always
 * exist in the array.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/majority-element/}
 *
 */
public class bit_majority_element
{
    /**
     * Runtime: O(n) — Bit manipulation: We would need 32 iterations, each
     * calculating the number of 1's for the ith bit of all n numbers. Since a
     * majority must exist, therefore, either count of 1's > count of 0's or
     * vice versa (but can never be equal). The majority number’s ith bit must
     * be the one bit that has the greater count.
     *
     */
    public int majorityElement(int[] nums)
    {
        int[] bits = new int[32];
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            int num = nums[i];

            for (int j = 0; j < 32; ++j) {
                if ((num & (1 << j)) != 0) {
                    bits[j]++;
                }
            }
        }

        int result = 0, half = n / 2;
        for (int i = 0; i < 32; ++i) {
            if (bits[i] > half) {
                result |= (1 << i);
            }
        }

        return result;
    }
}

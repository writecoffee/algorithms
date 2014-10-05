/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/single-number/}
 *
 */
public class bit_single_number_I {
    public int singleNumber(int[] array)
    {
        int x = 0;

        for (int i = 0; i < array.length; ++i) {
            x ^= array[i];
        }

        return x;
    }
}
/**
 * Given an array of integers, every element appears three times except for one. Find that single
 * one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 * 
 * Could you implement an method which can beat the previous solution? This time please try to
 * simulate ternary number operation.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/single-number-ii/}
 * 
 */
public class bit_single_number_III {
    public int singleNumber(int[] array) {
        int n = array.length, x = 0, ones = 0, twos = 0;

        for (int i = 0; i < n; ++i) {
            int val = array[i];

            twos |= (ones & val);
            ones ^= val;
            x = ~(ones & twos);
            ones &= x;
            twos &= x;
        }

        return ones;
    }
}
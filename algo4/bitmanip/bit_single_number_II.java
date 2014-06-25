/**
 * Given an array of integers, every element appears three times except for one. Find that single
 * one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/single-number-ii/}
 * 
 */
public class bit_single_number_II {
    public int singleNumber(int[] array) {
        int x = 0, n = array.length;

        for (int i = 0; i < 32; ++i) {
            int count = 0;
            int bit = 1 << i;

            for (int j = 0; j < n; ++j) {
                if ((array[j] & bit) != 0) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                x |= bit;
            }
        }

        return x;
    }
}
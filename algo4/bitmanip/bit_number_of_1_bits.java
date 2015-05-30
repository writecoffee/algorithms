/**
 * Write a function that takes an unsigned integer and returns the number of ’1'
 * bits it has (also known as the Hamming weight).
 *
 * For example, the 32-bit integer ’11' has binary representation
 * 00000000000000000000000000001011, so the function should return 3.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/number-of-1-bits/}
 *
 */
public class bit_number_of_1_bits
{
    public int hammingWeight(int n)
    {
        int result = 0;

        for (int i = 0; i < 32; ++i) {
            if ((n & (1 << i)) != 0) {
                result++;
            }
        }

        return result;
    }

    public int hammingWeightTrick(int n)
    {
        int result = 0;

        while (n != 0) {
            result++;
            n &= (n - 1);
        }

        return result;
    }
}

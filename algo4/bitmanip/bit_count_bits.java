package bitvector;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤
 * i ≤ num calculate the number of 1's in their binary representation and return
 * them as an array.
 *
 * Example: For num = 5 you should return [0,1,1,2,1,2].
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/counting-bits/}
 * [Difficulty] - Medium
 *
 */
public class bit_count_bits
{
    public int[] countBits(int num)
    {
        int[] result = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            result[i] = result[(i >> 1)] + i % 2;
        }

        return result;
    }
}

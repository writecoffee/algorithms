/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 *
 * For example, given the range [5, 7], you should return 4.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/bitwise-and-of-numbers-range/}
 *
 */
public class bit_bitwise_and_of_numbers_range
{
    /**
     * AND operation extract the left most consecutive common part of m and n.
     * (Just consider two numbers). So keep right shift until they are equal,
     * which means it reaches the left most consecutive common part.
     */
    public int rangeBitwiseAnd(int m, int n)
    {
        int count = 0;

        while (m != n) {
            m >>= 1;
            n >>= 1;

            count++;
        }

        return m << count;
    }
}

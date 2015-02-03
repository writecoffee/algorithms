/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 964176192 (represented in binary as
 * 00111001011110000010100101000000).
 *
 * Follow up: If this function is called many times, how would you optimize it?
 *
 * Related problem: Reverse Integer
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/reverse-bits/}
 * [Difficulty] - Easy
 *
 */
public class bit_reverse_bits
{
    public int reverseBits(int n)
    {
        int result = 0;

        for (int i = 0; i < 32; ++i) {
            result = (result << 1) | (1 & (n >>> i));
        }

        return result;
    }

    private static int[] preprocessed = new int[256];
    static {
        for (int i = 0; i < 256; ++i) {
            preprocessed[i] = reverseBitsPreprocessing(i);
        }
    }

    private static int reverseBitsPreprocessing(int n)
    {
        int result = 0;

        for (int i = 0; i < 8; ++i) {
            result = (result << 1) | (1 & (n >>> i));
        }

        return result;
    }

    public int reverseBitsApiCall(int n) {
        int result = 0;

        for (int i = 0; i < 32; i += 8) {
            result = (result << 8) | preprocessed[(n >>> i) & 255];
        }

        return result;
    }
}

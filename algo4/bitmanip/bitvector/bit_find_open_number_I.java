package bitvector;

/**
 * Given an input file with four billion NON-NEGATIVE integers, provide an algorithm to generate an
 * integer which is not contained in the file. Assume you have 1 GB of memory available for this
 * task
 * 
 * Assume that the file is parsed into an integer array, we have also recorded the upper bound,
 * EXCLUSIVE, as well.
 * 
 * Return -1 if all numbers are existent.
 * 
 * [Difficulty] - Hard
 * [Source]     - {@linkplain CC150-10.3}
 * 
 */
public class bit_find_open_number_I {
    public int findOpenNumber(int[] array, int upperBound) {
        int n = array.length;
        byte[] bv = new byte[upperBound / 8 + ((upperBound % 8) != 0 ? 1 : 0)];

        for (int i = 0; i < n; ++i) {
            bv[array[i] / 8] |= 1 << (array[i] % 8);
        }

        for (int i = 0; i < bv.length; ++i) {
            for (int j = 0; j < 8; ++j) {
                if ((bv[i] & (1 << j)) == 0) {
                    return i * 8 + j;
                }
            }
        }

        return -1;
    }
}
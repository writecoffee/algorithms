package bitvector;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Given an input file with four billion non-negative integers, provide an algorithm to generate an
 * integer which is not contained in the file. You have only 10 MB of memory? Assume that all the values
 * are distinct.
 * 
 * [Difficulty] - Hard
 * [Source]     - {@linkplain CC150-10.3}
 * 
 */
public class bit_find_open_number_II {
    private int blockSize = 2 ^ 20;
    private int blockCount = 2 ^ 11;
    private byte[] bv = new byte[blockSize / 8];
    private int[] blockCounters = new int[blockCount];

    /**
     * There are a total of 2^32, or 4 billion, distinct integers possible (and 2^31 non-negative
     * integers). We only have 10 MB of memory, which is 2^20 * 10 bytes.
     * 
     * Let rangeSize be the size of the ranges that each block in the first pass represents.
     * 
     * Let blockCount represent the number of blocks in the first pass. Note that arraySize = 2^31 /
     * rangeSize, since there are 2^31 non-negative integers.
     * 
     * We need to select a value for rangeSize such that the memory from the first pass (the array) and
     * the second pass (the bit vector) fit.
     * 
     * (1) First Pass: The Array
     * 
     *     The array in the first pass can fit in 10 megabytes, or roughly 2^23 bytes, of memory. Since
     *     each element in the array is an integer, and an integer is 4 bytes, we can hold an array of
     *     at most about 2^21 elements. So we can derive the following:
     * 
     *     blockCount = 2^31 / blockSize <= 2^21
     *                         blockSize >= 2^10
     * 
     * (2) Second Pass: The Bit Vector
     * 
     *     We need to have enough space to store rangeSize bits. Since we can fit 2^23 bytes in memory,
     *     and thus we have an upper bound for blockSize, which is:
     * 
     *     2^10 <= blockSize <= 2^26
     * 
     */
    public int findOpenNumber() throws FileNotFoundException {
        int starting = -1;
        Scanner in = new Scanner(new FileReader("file.txt"));
        while (in.hasNextInt()) {
            int number = in.nextInt();
            blockCounters[number / blockSize]++;
        }

        /*
         * If the counter is smaller than the block size, then there is at least 1
         * number is missing in that section.
         */
        for (int i = 0; i < blockCounters.length; i++) {
            if (blockCounters[i] < blockSize) {
                starting = i * blockSize;
                break;
            }
        }

        /*
         * Filter all numbers which are within the range of that block.
         */
        in = new Scanner(new FileReader("file.txt"));
        while (in.hasNextInt()) {
            int number = in.nextInt();

            if (number >= starting && number < starting + blockSize) {
                bv[(number - starting) / 8] |= 1 << ((number - starting) % 8);
            }
        }

        /*
         * Retrieves the individual bits of each byte. When 0 bit is found, restore
         * the corresponding value.
         */
        for (int i = 0; i < bv.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bv[i] & (1 << j)) == 0) {
                    return starting + i * 8 +  j;
                }
            }
        }

        return -1;
    }
}
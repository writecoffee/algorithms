import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * There are a total of 2^32, or 4 billion, distinct integers possible (and 2^31 non-negative
 * integers). We have 10 MB of memory.
 * 
 * Let rangeSize be the size of the ranges that each block in the first pass represents.
 * 
 * Let arraySize represent the number of blocks in the first pass. Note that arraySize = 2^31 /
 * rangeSize, since there are 2^31 non-negative integers.
 * 
 * We need to select a value for rangeSize such that the memory from the first pass (the array) and
 * the second pass (the bit vector) fit.
 * 
 * (1) First Pass: The Array
 * 
 *     The array in the first pass can fit in 10 megabytes, or roughly 2^23 bytes, of memory. Since
 *     each element in the array is an integer, and an integer is 4 bytes, we can hold an array of
 *     at most about 2^21 elements. So we can deduce the following:
 * 
 *     arraySize = 2^31 / rangeSize <= 2^21
 *                        rangeSize >= 2^10
 * 
 * (2) Second Pass: The Bit Vector
 * 
 *     We need to have enough space to store rangeSize bits. Since we can fit 2^23 bytes in memory,
 *     we can fit 2^26 bits in memory. Therefore, we can conclude the following:
 * 
 *     2^10 <= rangeSize <= 2^26
 * 
 */
public class bit_find_open_number_II {
    private int rangeSize = 2 ^ 20;
    private int arraySize = 2 ^ 12;
    private byte[] bitfield = new byte[rangeSize / 8];
    private int[] blockCounters = new int[arraySize];

    public int findOpenNumber() throws FileNotFoundException {
        int starting = -1;
        Scanner in = new Scanner(new FileReader("file.txt"));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            blockCounters[n / rangeSize]++;
        }

        /*
         * if value < 2^20, then at least 1 number is missing in that section.
         */
        for (int i = 0; i < blockCounters.length; i++) {
            if (blockCounters[i] < rangeSize) {
                starting = i * rangeSize;
                break;
            }
        }

        /*
         * If the number is inside the block that's missing numbers, we record it
         */
        in = new Scanner(new FileReader("file.txt"));
        while (in.hasNextInt()) {
            int n = in.nextInt();

            if (n >= starting && n < starting + rangeSize) {
                bitfield[(n - starting) / 8] |= 1 << ((n - starting) % 8);
            }
        }

        /*
         * Retrieves the individual bits of each byte. When 0 bit is found, finds
         * the corresponding value.
         */
        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitfield[i] & (1 << j)) == 0) {
                    return starting + i * 8 +  j;
                }
            }
        }

        return -1;
    }
}
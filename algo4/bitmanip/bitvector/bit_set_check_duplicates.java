package bitvector;

import java.util.ArrayList;

/**
 * You have an array with all the numbers from 1 to N, where N is at most 32,000. The array may have
 * duplicate entries and you do not know what N is.
 * 
 * With only 4 kilobytes of memory available, how would you print all duplicate elements in the
 * array?
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain CC150-10.4}
 * 
 */
public class bit_set_check_duplicates {
    private class BitSet {
        private int[] bitset;

        private BitSet(int size) {
            bitset = new int[size >> 5];
        }

        private boolean get(int pos) {
            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        private void set(int pos) {
            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }

    public ArrayList<Integer> checkDuplicates(int[] array) {
        return checkDuplicates(array, 32000);
    }

    private ArrayList<Integer> checkDuplicates(int[] array, int upperBound) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        BitSet bs = new BitSet(upperBound);
        int n = array.length;

        for (int i = 0; i < n; ++i) {
            int num = array[i], num0 = num - 1;

            if (bs.get(num0)) {
                result.add(num);
            } else {
                bs.set(num0);
            }
        }

        return result;
    }
}
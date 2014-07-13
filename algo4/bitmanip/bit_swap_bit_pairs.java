/**
 * Swap adjacent bits for a given number.
 * 
 * For example:
 * 
 * Given 10011101, transform it to 01101110.
 * 
 * [Difficulty] - Easy
 * [Source]     - google interview
 *
 */
public class bit_swap_bit_pairs {
    public int swap(int number) {
        return ((number >>> 1) & 0x55555555) | ((number << 1) & 0xAAAAAAAA);
    }
}
/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 *
 * For example:
 *
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is
 * also correct.
 *
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/single-number-iii/}
 * [Difficulty] - Hard
 *
 */
public class bit_single_number_III
{
    /**
     * Because the two resulting numbers are different, there exist
     * at least one bit, B, that is in the XOR result among all the numbers.
     *
     * Pick any of B, partition the numbers into two groups. XOR the two
     * partitions respectively we will gain the result.
     *
     */
    public int[] singleNumber(int[] nums)
    {
        int diff = 0;

        for (int number : nums) {
            diff ^= number;
        }

        diff = Integer.highestOneBit(diff);
        int[] result = new int[2];

        for (int number : nums) {
            if ((diff & number) == 0) {
                result[0] = result[0] ^= number;
            } else {
                result[1] = result[1] ^= number;
            }
        }

        return result;
    }
}

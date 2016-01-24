/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/power-of-two/}
 * [Tag]        - $math$
 *
 */
public class bit_power_of_two
{
    public boolean isPowerOfTwo(int n)
    {
        for (int i = 0; i < 31; ++i) {
            int mask = 1 << i;

            if ((mask ^ n) == 0) {
                return true;
            }
        }

        return false;
    }
}

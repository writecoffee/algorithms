/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the
 * operator + and -.
 *
 * Example: Given a = 1 and b = 2, return 3.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/sum-of-two-integers/}
 * [Difficulty] - Medium
 *
 */
public class bit_add_two_numbers
{
    /**
     * We can think of & as for generating carry, ^ for generating sum.
     *
     * Now design a for loop where we can terminate. Let y to be carry, x to be sum
     * so that we can check y to be termination condition.
     *
     */
    public int add(int x, int y)
    {
        while (y != 0) {
            int carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }

        return x;
    }
}

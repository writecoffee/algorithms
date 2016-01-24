package number_theory;

/**
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Follow up: Could you do it without using any loop / recursion?
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/power-of-three/}
 *
 */
public class math_nt_power_of_three
{
    /**
     * If N is a power of 3, let X to be the unknown number:
     *
     * ==> 3^X == N
     * ==> log (3^X) == log N
     * ==> X log 3 == log N
     * ==> X == (log N) / (log 3)
     *
     * For the basis to hold, X must be an integer.
     *
     */
    public boolean isPowerOfThree(int n)
    {
        int maxPowerOfThree = (int) Math.pow(3, (int) (Math.log(0x7fffffff) / Math.log(3)));

        return n > 0 && maxPowerOfThree % n == 0;
    }
}

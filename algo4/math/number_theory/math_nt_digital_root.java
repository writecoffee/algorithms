package number_theory;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 *
 * For example:
 *
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
 * one digit, return it.
 *
 * Follow up: Could you do it without any loop/recursion in O(1) runtime?
 *
 * Hint:
 *
 * A naive implementation of the above process is trivial. Could you come up
 * with other methods?
 *
 * What are all the possible results?
 *
 * How do they occur, periodically or randomly?
 *
 * You may find this Wikipedia article useful.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/add-digits/}
 *
 */
public class math_nt_digital_root
{
    /**
     * d(1) = 1 mod 9, d(10) = (1 * 10 + 0) = 1 mod 9
     *
     * Hence we can calculate the digital root regardless of the digit significance.
     *
     */
    public int addDigits(int num)
    {
        return (num - 1) % 9 + 1;
    }
}

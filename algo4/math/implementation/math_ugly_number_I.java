package implementation;

/**
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another
 * prime factor 7.
 *
 * Note that 1 is typically treated as an ugly number.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/ugly-number/}
 *
 */
public class math_ugly_number_I
{
    public boolean isUgly(int num)
    {
        if (num <= 0) {
            return false;
        }

        // remove 2's.
        num >>>= Integer.numberOfTrailingZeros(num);

        // remove 3's
        while (num % 3 == 0) {
            num = num / 3;
        }

        // remove 5's
        while (num % 5 == 0) {
            num = num / 5;
        }
        return num == 1;
    }
}

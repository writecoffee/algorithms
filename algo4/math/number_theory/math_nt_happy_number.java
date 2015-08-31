package number_theory;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^*2 = 1
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/happy-number/}
 *
 */
public class math_nt_happy_number
{
    public boolean isHappy(int n)
    {
        Set<Integer> visited = new HashSet<Integer>();

        while (!visited.contains(n) && n != 1) {
            visited.add(n);
            int newN = 0;

            for (int t = n; t != 0; t /= 10) {
                int digit = t % 10;
                newN += digit * digit;
            }

            n = newN;
        }

        return n == 1;
    }
}

package conversion;

import java.util.Arrays;
import java.util.List;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 *
 * [Difficulty] - Easy
 * [Source]     - facebook interview,
 *                {@linkplain https://oj.leetcode.com/problems/roman-to-integer/}
 *
 */
public class math_conv_roman_to_integer
{
    /**
     * Any of the letters representing numbers in the Roman numerical system:
     * 
     * I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000.
     *
     * In this system, a letter placed after another of greater value adds
     * (thus XVI or xvi is 16), whereas a letter placed before another of
     * greater value subtracts (thus XC or xc is 90).
     * 
     */
    public int romanToInt(String s)
    {
        int[] ints = { 1, 5, 10, 50, 100, 500, 1000 };
        List<Character> romans = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');

        int n = s.length();
        int result = ints[romans.indexOf(s.charAt(n - 1))];

        for (int i = n - 2; i >= 0; --i) {
            int v1 = ints[romans.indexOf(s.charAt(i))];
            int v2 = ints[romans.indexOf(s.charAt(i + 1))];

            if (v1 >= v2) {
                result += v1;
            } else {
                result -= v1;
            }
        }

        return result;
    }
}

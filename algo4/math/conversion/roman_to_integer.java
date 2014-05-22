package conversion;

import java.util.Arrays;
import java.util.List;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * https://oj.leetcode.com/problems/roman-to-integer/
 * 
 */
public class roman_to_integer {
    public int romanToInt(String s) {
        int[] ints = { 1, 5, 10, 50, 100, 500, 1000 };
        List<Character> romans = Arrays.asList('I', 'V', 'X', 'L', 'C', 'D', 'M');

        int result = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; ++i) {
            int d1 = ints[romans.indexOf(s.charAt(i))];
            int d2 = ints[romans.indexOf(s.charAt(i + 1))];

            if (d1 >= d2) {
                result += d1;
            } else {
                result -= d1;
            }
        }

        result += ints[romans.indexOf(s.charAt(n - 1))];
        return result;
    }
}
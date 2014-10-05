import java.util.Arrays;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180
 * degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is
 * represented as a string.
 *
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 *
 * [Difficulty]     - Easy
 * [Tediousness]    - Medium
 * [Source]         - {@linkplain https://leetcode.com/problems/strobogrammatic-number/}
 *
 */
public class str_strobogrammatic_number
{
    /**
     * You can start out by comparing each character at the beginning of the
     * string to each character at the end of the string and seeing if those
     * characters are suitable rotations of each other. The only digits that are
     * valid rotations of another digit are: 0 -> 0, 1 -> 1, 6 -> 9, 8 -> 8, and
     * 9 -> 6. So if the currently examined digit is one of these digits,
     * compare it to the corresponding digit at the other end of the string and
     * see if it is the digit mapped to in the lookup table. If it is not found
     * in the lookup table (for example if it was a 2, 3, 4, 5, or 7) or if it
     * is not matched with the required digit, then the number cannot be
     * strobogrammatic.
     *
     */
    public boolean isStrobogrammatic(String num)
    {
        int i = 0, j = num.length() - 1;
        List<Character> strobogram = Arrays.asList('8', '0', '1');

        for (; i < j; i++, j--) {
            char p = num.charAt(i), q = num.charAt(j);

            if (!((p == '6' && q == '9') || (p == '9' && q == '6') || (p == q && strobogram.contains(p)))) {
                return false;
            }
        }

        if (i == j && num.length() > 0) {
            return strobogram.contains(num.charAt(i));
        }

        return true;
    }
}

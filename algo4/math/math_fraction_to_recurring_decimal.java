import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the
 * fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * For example,
 *
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 *
 *     0.16
 * 6 ) 1.00
 *     0
 *     1 0       <-- Remainder=1, mark 1 as seen at position=0.
 *     - 6
 *       40      <-- Remainder=4, mark 4 as seen at position=1.
 *     - 36
 *        4      <-- Remainder=4 was seen before at position=1, so the fractional part which
 *                   is 16 starts repeating at position=1 => 1(6).
 *
 * The key insight here is to notice that once the remainder starts repeating, so does the
 * divided result.
 *
 * You will need a hash table that maps from the remainder to its position of the fractional
 * part. Once you found a repeating remainder, you may enclose the recurring fractional part
 * with parentheses by consulting the position from the table.
 *
 * The remainder could be zero while doing the division. That means there is no repeating
 * fractional part and you should stop right away.
 *
 * Just like the question Divide Two Integers, be wary of edge case such as negative fractions
 * and nasty extreme case such as -2147483648 / -1.
 *
 * [Difficulty]     - Hard
 * [Source]         - facebook interview, {@linkplain https://leetcode.com/problems/fraction-to-recurring-decimal/}
 * [Tediousness]    - Low
 * [Tag]            - $bit$
 *
 */
public class math_fraction_to_recurring_decimal
{
    public String fractionToDecimal(int n, int d)
    {
        if (n == 0) {
            return "0";
        } else if (d == 0) {
            return "NaN";
        }

        StringBuilder sb = new StringBuilder();
        Map<Long, Integer> recurring = new HashMap<Long, Integer>();

        if ((n < 0) ^ (d < 0)) {
            sb.append("-");
        }

        long numerator = Math.abs((long) n),
             denominator = Math.abs((long) d),
             quotient = numerator / denominator,
             remainder = (numerator % denominator) * 10;

        sb.append(quotient);
        if (remainder == 0) {
            return sb.toString();
        }

        sb.append(".");

        while (remainder != 0) {
            if (recurring.containsKey(remainder)) {
                sb.insert(recurring.get(remainder), "(");
                sb.append(")");
                return sb.toString();
            }

            recurring.put(remainder, sb.length());
            quotient = remainder / denominator;
            sb.append(quotient);
            remainder = (remainder % denominator) * 10;
        }

        return sb.toString();
    }
}

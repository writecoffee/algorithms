package number_theory;

/**
 * Given an integer n, count the total number of digit 1 appearing in all
 * non-negative integers less than or equal to n.
 *
 * For example: Given n = 13, Return 6, because digit 1 occurred in the
 * following numbers: 1, 10, 11, 12, 13.
 *
 * Show Hint Show Tags Show Similar Problems
 *
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/number-of-digit-one/}
 *
 */
public class math_nt_count_number_of_2s_between_0_and_n
{
    /**
     * The algorithm is to iterate through all digits in the number from right
     * to left and discuss how many times 1 can appear at each position.
     *
     * So when we sum all appearance of 2 for each position we can yield the
     * result.
     *
     */
    public int countDigitOne(int number)
    {
        String str = String.valueOf(number);
        int count = 0, n = str.length();

        for (int i = 0; i < n; i++) {
            count += count2sInRangeAtDigit(number, i, n);
        }

        return count;
    }

    /**
     *  1 3 4 5 6 9 1
     *  ___ | _______
     *   l  d    r
     *
     * Imagine there is a counter that count from 0 to "number".
     *
     * The shortcut for computing the occurrence is to partition the number into three part
     * and we count how many times that we can loop through that digit.
     *
     */
    private long count2sInRangeAtDigit(int number, int d, int n)
    {
        long signaficance = (long) Math.pow(10, d),
             l = number / (signaficance * 10),
             r = number % signaficance,
             digit = number / signaficance % 10;

        if (digit == 1) {
            return l * signaficance + r + 1;
        } else if (digit < 1) {
            return l * signaficance;
        } else {
            return (l + 1) * signaficance;
        }
    }
}

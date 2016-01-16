/**
 * Additive number is a string whose digits can form additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for
 * the first two numbers, each subsequent number in the sequence must be the sum
 * of the preceding two.
 *
 * For example:
 *
 * "112358" is an additive number because the digits can form an additive
 * sequence: 1, 1, 2, 3, 5, 8.
 *
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 *
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100,
 * 199.
 *
 * 1 + 99 = 100, 99 + 100 = 199
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence
 * 1, 2, 03 or 1, 02, 3 is invalid.
 *
 * Given a string containing only digits '0'-'9', write a function to determine
 * if it's an additive number.
 *
 * Follow up:
 *
 * How would you handle overflow for very large input integers?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/additive-number/}
 * [Difficulty] - Medium
 *
 */
public class dfs_additive_number_check
{
    public boolean isAdditiveNumber(String num)
    {
        int n = num.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                long num1 = getNum(num, 0, i + 1);
                long num2 = getNum(num, i + 1, j + 1);

                if (num1 == -1 || num2 == -1) {
                    continue;
                }

                if (explore(num1, num2, j + 1, num, n)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean explore(long num1, long num2, int start, String num, int n)
    {
        if (start == n) {
            return true;
        }

        for (int i = start; i < n; i++) {
            long nextNum = getNum(num, start, i + 1);

            if (nextNum == -1) {
                continue;
            } else if (nextNum != num1 + num2) {
                continue;
            }

            if (explore(num2, nextNum, i + 1, num, n)) {
                return true;
            }
        }

        return false;
    }

    private long getNum(String num, int i, int j)
    {
        if (num.charAt(i) == '0' && j - i > 1) {
            return -1;
        }

        return Long.valueOf(num.substring(i, j));
    }
}

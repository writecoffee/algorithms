package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees
 * (looked at upside down).
 *
 * Write a function to count the total strobogrammatic numbers that exist in the range
 * of low <= num <= high.
 *
 * For example,
 *
 * Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic
 * numbers.
 *
 * Note:
 *
 * Because the range might be a large number, the low and high numbers are represented as string.
 *
 *
 * [Difficulty]     - Medium
 * [Source]         - {@linkplain https://leetcode.com/problems/strobogrammatic-number-iii/}
 * [Tediousness]    - High
 *
 */
public class dfs_combination_strobogrammatic_number_III
{
    public int strobogrammaticInRange(String low, String high)
    {
        int len1 = low.length(), len2 = high.length(), result = 0;

        for (int l = len1; l <= len2; l++) {
            result += explore(0, l, low.toCharArray(), high.toCharArray(),  new Stack<>(), new Stack<>());
        }

        return result;
    }

    private static List<String>    stroboPair   = Arrays.asList("00", "11", "69", "96", "88");
    private static List<Character> stroboSingle = Arrays.asList('0', '1', '8');

    private int explore(int depth, int n, char[] low, char[] high, Stack<Character> heads, Stack<Character> tails)
    {
        if (n == 1) {
            int count = 0;

            for (Character mid : stroboSingle) {
                char[] number = construct(new ArrayList<>(heads), mid, new ArrayList<>(tails));

                if (compare(number, low) >= 0 && compare(number, high) <= 0) {
                    count++;
                }
            }

            return count;
        } else if (n == 0) {
            char[] number = construct(new ArrayList<>(heads), null, new ArrayList<>(tails));

            if (compare(number, low) >= 0 && compare(number, high) <= 0) {
                return 1;
            } else {
                return 0;
            }
        }

        int count = 0;

        for (String pair : stroboPair) {
            if (depth == 0 && pair.charAt(0) == '0') {
                continue;
            }

            heads.push(pair.charAt(0));
            tails.push(pair.charAt(1));
            count += explore(depth + 1, n - 2, low, high, heads, tails);
            heads.pop();
            tails.pop();
        }

        return count;
    }

    private char[] construct(ArrayList<Character> heads, Character mid, ArrayList<Character> tails)
    {
        int headSize = heads.size();
        char[] result = new char[headSize + (mid != null ? 1 : 0) + tails.size()];

        for (int i = 0; i < headSize; i++) {
            result[i] = heads.get(i);
        }

        if (mid != null) {
            result[headSize] = mid;
        }

        for (int i = 0; i < tails.size(); i++) {
            result[headSize + (mid != null ? 1 : 0) + i] = tails.get(tails.size() - 1 - i);
        }

        return result;
    }

    private int compare(char[] number, char[] toBeCmp)
    {
        int len1 = number.length, len2 = toBeCmp.length;

        if (len1 > len2) {
            return 1;
        } else if (len1 < len2) {
            return -1;
        }

        for (int i = 0; i < len1; i++) {
            if (number[i] == toBeCmp[i]) {
                continue;
            }

            return number[i] - toBeCmp[i];
        }

        return 0;
    }
}

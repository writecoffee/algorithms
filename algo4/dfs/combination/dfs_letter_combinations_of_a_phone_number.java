package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Input: Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/}
 *
 */
public class dfs_letter_combinations_of_a_phone_number
{
    public List<String> letterCombinations(String digits)
    {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        char[] cdigits = digits.toCharArray();
        String[] cmaps = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        explore(0, cdigits.length, cdigits, cmaps, new char[cdigits.length], result);
        return result;
    }

    private void explore(int i, int n, char[] cdigits, String[] cmaps, char[] path, List<String> result)
    {
        if (i == n) {
            result.add(new String(path));
            return;
        }

        char[] charPermutation = cmaps[cdigits[i] - '0'].toCharArray();

        /*
         * If user pressed "1", let path[i] = null, but remember to skip
         * the null values when constructing the result.
         *
         */
        if (charPermutation.length == 0) {
            explore(i + 1, n, cdigits, cmaps, path, result);
            return;
        }

        for (char c : charPermutation) {
            path[i] = c;
            explore(i + 1, n, cdigits, cmaps, path, result);
        }
    }
}

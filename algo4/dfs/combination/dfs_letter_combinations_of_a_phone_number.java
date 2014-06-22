package combination;

import java.util.ArrayList;

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
public class dfs_letter_combinations_of_a_phone_number {
    public ArrayList<String> letterCombinations(String digits) {
        char[] cdigits = digits.toCharArray();
        String[] cmaps = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ArrayList<String> result = new ArrayList<String>();
        explore(0, cdigits.length, cdigits, cmaps, new char[cdigits.length], result);
        return result;
    }

    private void explore(int i, int n, char[] cdigits, String[] cmaps, char[] path, ArrayList<String> result) {
        if (i == n) {
            result.add(new String(path));
            return;
        }

        for (Character c : cmaps[cdigits[i] - '0'].toCharArray()) {
            path[i] = c;
            explore(i + 1, n, cdigits, cmaps, path, result);
        }
    }
}
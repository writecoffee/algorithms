import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty substring in str.
 *
 * Examples:
 *
 * 1. pattern = "abab", str = "redblueredblue" should return true.
 * 2. pattern = "aaaa", str = "asdasdasdasd" should return true.
 * 3. pattern = "aabb", str = "xyzabcxzyabc" should return false.
 *
 * Notes:
 *
 * You may assume both pattern and str contains only lowercase letters.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/word-pattern-ii/}
 * [Difficulty] - Hard
 *
 */
public class dfs_word_pattern_II
{
    public boolean wordPatternMatch(String pattern, String str)
    {
        return explore(pattern.toCharArray(), 0, str, 0, new HashMap<Character, String>());
    }

    private boolean explore(char[] pattern, int i, String str, int j, HashMap<Character, String> pToString)
    {
        if (i == pattern.length && j == str.length() && new HashSet<String>(pToString.values()).size() == pToString.size()) {
            return true;
        } else if (i == pattern.length || j == str.length()) {
            return false;
        }

        char theP = pattern[i];
        for (int k = j + 1; k <= str.length(); k++) {
            String theNextStr = str.substring(j, k);

            if (!pToString.containsKey(theP)) {
                pToString.put(theP, theNextStr);

                if (explore(pattern, i + 1, str, k, pToString)) {
                    return true;
                }

                pToString.remove(theP);

            } else if (pToString.get(theP).equals(theNextStr)) {

                if (explore(pattern, i + 1, str, k, pToString)) {
                    return true;
                }
            }
        }

        return false;
    }
}

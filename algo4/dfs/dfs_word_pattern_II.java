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

    private boolean explore(char[] pattern, int iPattern, String str, int iStr, HashMap<Character, String> pToString)
    {
        if (iPattern == pattern.length && iStr == str.length() && new HashSet<String>(pToString.values()).size() == pToString.size()) {
            return true;
        } else if (iPattern == pattern.length || iStr == str.length()) {
            return false;
        }

        char p = pattern[iPattern];
        for (int k = iStr + 1; k <= str.length(); k++) {
            String theNextStr = str.substring(iStr, k);

            if (!pToString.containsKey(p)) {
                pToString.put(p, theNextStr);

                if (explore(pattern, iPattern + 1, str, k, pToString)) {
                    return true;
                }

                pToString.remove(p);

            } else if (pToString.get(p).equals(theNextStr)) {

                if (explore(pattern, iPattern + 1, str, k, pToString)) {
                    return true;
                }
            }
        }

        return false;
    }
}

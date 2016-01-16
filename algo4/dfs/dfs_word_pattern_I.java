import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a
 * letter in pattern and a non-empty word in str.
 *
 * Examples:
 *
 * pattern = "abba", str = "dog cat cat dog" should return true.
 *
 * pattern = "abba", str = "dog cat cat fish" should return false.
 *
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 *
 * pattern = "abba", str = "dog dog dog dog" should return false.
 *
 * Notes:
 *
 * You may assume pattern contains only lowercase letters, and str contains
 * lowercase letters separated by a single space.
 *
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/word-pattern/}
 * [Difficulty] - Easy
 *
 */
public class dfs_word_pattern_I
{
    public boolean wordPattern(String pattern, String str)
    {
        String[] words = str.split(" ");
        String[] ps = pattern.split("");

        if (pattern.length() != words.length) {
            return false;
        }

        Map<String, String> pToWord = new HashMap<>();
        int n = words.length;

        for (int i = 0; i < n; i++) {
            if (!pToWord.containsKey(ps[i])) {
                pToWord.put(ps[i], words[i]);
            } else if (!pToWord.get(ps[i]).equals(words[i])) {
                return false;
            }
        }

        return pToWord.values().size() == new HashSet<>(pToWord.values()).size();
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 *
 * For example, Given "egg", "add", return true.
 *
 * Given "foo", "bar", return false.
 *
 * Given "paper", "title", return true.
 *
 * Note: You may assume both s and t have the same length.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/isomorphic-strings/}
 *
 */
public class str_isomorphic_strings
{
    public boolean isIsomorphic(String s, String t)
    {
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        Map<Character, Character> sMapper = new HashMap<Character, Character>(),
                                  tMapper = new HashMap<Character, Character>();

        for (int i = 0; i < n; ++i) {
            char a = s.charAt(i), b = t.charAt(i);

            if (!sMapper.containsKey(a) && !tMapper.containsKey(b)) {
                sMapper.put(a, a);
                tMapper.put(b, a);

            } else if (sMapper.containsKey(a)
                    && tMapper.containsKey(b)
                    && sMapper.get(a) == tMapper.get(b)) {
                continue;

            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isIsomorphicSingleMap(String s, String t)
    {
        if (s.length() != t.length()) {
            return false;
        }

        int n = s.length();
        Map<String, Character> mapper = new HashMap<String, Character>();

        for (int i = 0; i < n; ++i) {
            char a = s.charAt(i),
                 b = t.charAt(i);

            String keyA = "l" + a,
                   keyB = "r" + b;

            if (!mapper.containsKey(keyA) && !mapper.containsKey(keyB)) {
                mapper.put(keyA, b);
                mapper.put(keyB, a);
            } else if (mapper.containsKey(keyA)
                    && mapper.containsKey(keyB)
                    && mapper.get(keyA) == b) {
                continue;
            } else {
                return false;
            }
        }

        return true;
    }
}

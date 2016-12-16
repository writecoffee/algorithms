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
 * [Tag]        - $mapping$
 *
 */
public class str_isomorphic_strings
{
    public boolean isIsomorphic(String s, String t)
    {
        int m = s.length();
        int n = t.length();
        if (m != n) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char sc = sChars[i];
            char tc = tChars[i];
            Character sMapped = sMap.get(sc);
            Character tMapped = tMap.get(tc);

            if (sMapped == null && tMapped == null) {
                sMap.put(sc, tc);
                tMap.put(tc, sc);
            } else if (sMapped == null || tMapped == null) {
                return false;
            } else if (sMapped != tc || tMapped != sc) {
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
            char sc = s.charAt(i);
            char tc = t.charAt(i);

            String sKey = "l" + sc;
            String tKey = "r" + tc;

            Character sMapped = mapper.get(sKey);
            Character tMapped = mapper.get(tKey);

            if (sMapped == null && tMapped == null) {
                mapper.put(sKey, tc);
                mapper.put(tKey, sc);
            } else if (sMapped == null || tMapped == null) {
                return false;
            } else if (sMapped != tc || tMapped != sc) {
                return false;
            }
        }

        return true;
    }
}

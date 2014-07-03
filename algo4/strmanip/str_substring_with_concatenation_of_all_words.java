import java.util.ArrayList;
import java.util.HashMap;

/**
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 * 
 * For example, given:
 * 
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * 
 * You should return the indices: [0,9] (order does not matter).
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/}
 *
 */
public class str_substring_with_concatenation_of_all_words {
    public ArrayList<Integer> findSubstring(String s, String[] l) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> need = new HashMap<String, Integer>();

        for (String t : l) {
            need.put(t, need.get(t) == null ? 1 : need.get(t) + 1);
        }

        int m = s.length(), n = l.length, stride = l[0].length();

        for (int i = 0, j = 0; i <= m - n * stride; ++i) {
            HashMap<String, Integer> found = new HashMap<String, Integer>();

            for (j = i; j < i + n * stride; j += stride) {
                String t = s.substring(j, j + stride);

                if (!need.containsKey(t)) {
                    break;
                } else if (!found.containsKey(t)) {
                    found.put(t, 1);
                } else if (found.get(t) == need.get(t)){
                    break;
                } else {
                    found.put(t, found.get(t) + 1);
                }
            }

            if (j == i + n * stride) {
                result.add(i);
            }
        }

        return result;
    }
}
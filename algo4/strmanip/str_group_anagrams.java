import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 *
 * Return:
 *
 * [
 *   ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 *
 * For the return value, each inner list's elements must follow the
 * lexicographic order.
 *
 * All inputs will be in lower-case.
 *
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/anagrams/}
 *
 */
public class str_group_anagrams
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> h = new HashMap<>();
        int n = strs.length;

        for (int i = 0; i < n; ++i) {
            String sign = getSignature(strs[i]);

            if (!h.containsKey(sign)) {
                h.put(sign, new ArrayList<String>());
            }

            h.get(sign).add(strs[i]);
        }

        for (Map.Entry<String, List<String>> ent : h.entrySet()) {
            Collections.sort(ent.getValue());
            result.add(ent.getValue());
        }

        return result;
    }

    private String getSignature(String s)
    {
        int[] counters = new int[256];
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            counters[s.charAt(i)]++;
        }

        for (char c = 0; c < 256; ++c) {
            if (counters[c] > 0) {
                sb.append(c);
                sb.append(counters[c]);
            }
        }

        return sb.toString();
    }
}

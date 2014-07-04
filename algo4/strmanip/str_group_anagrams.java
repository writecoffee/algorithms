import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/anagrams/}
 * 
 */
public class str_group_anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        TreeMap<String, ArrayList<String>> h = new TreeMap<String, ArrayList<String>>();
        int n = strs.length;

        for (int i = 0; i < n; ++i) {
            String sign = getSignature(strs[i]);

            if (!h.containsKey(sign)) {
                h.put(sign, new ArrayList<String>());
            }

            h.get(sign).add(strs[i]);
        }

        for (Entry<String, ArrayList<String>> ent : h.entrySet()) {
            ArrayList<String> value = ent.getValue();

            if (value.size() > 1) {
                result.addAll(value);
            }
        }

        return result;
    }

    private String getSignature(String s) {
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
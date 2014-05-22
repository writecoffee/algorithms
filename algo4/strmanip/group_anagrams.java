import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 
 * https://oj.leetcode.com/problems/anagrams/
 * 
 */
public class group_anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, ArrayList<String>> h = new HashMap<String, ArrayList<String>>();
        int n = strs.length;

        for (int i = 0; i < n; ++i) {
            String signature = getSignature(strs[i]);

            if (!h.containsKey(signature)) {
                h.put(signature, new ArrayList<String>());
            }

            h.get(signature).add(strs[i]);
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
        int[] chars = new int[256];
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            chars[s.charAt(i)]++;
        }

        for (int i = 0; i < 256; ++i) {
            if (chars[i] > 0) {
                sb.append((char) i);
                sb.append(chars[i]);
            }
        }

        return sb.toString();
    }
}
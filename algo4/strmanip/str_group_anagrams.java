import java.util.ArrayList;
import java.util.Arrays;
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
        Map<String, List<String>> h = new HashMap<>();
        Arrays.sort(strs);

        for (String s : strs) {
            String sign = getSignature(s);

            List<String> values = h.get(sign);
            if (values == null) {
                values = new ArrayList<>();
                h.put(sign, values);
            }

            values.add(s);
        }

        return new ArrayList<List<String>>(h.values());
    }

    private String getSignature(String s)
    {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

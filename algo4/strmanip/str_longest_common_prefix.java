/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/longest-common-prefix/}
 * 
 */
public class str_longest_common_prefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int m = strs.length, n = strs[0].length();

        for (int i = 0; i < n; i++) {
            char ch = strs[0].charAt(i);

            for (int j = 1; j < m; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return result.toString();
                }
            }

            result.append(ch);
        }

        return result.toString();
    }
}
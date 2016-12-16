/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/longest-common-prefix/}
 * 
 */
public class str_longest_common_prefix
{
    public String longestCommonPrefix(String[] strs)
    {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int m = strs.length, n = strs[0].length();

        for (int i = 0; i < n; i++) {
            // We can use the characters at the first string as the source of truth.
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

    public String longestCommonPrefix2(String[] strs)
    {
        StringBuilder sb = new StringBuilder();

        int n = strs.length;
        int prefix = 0;

        if (n == 0) {
            return "";
        }

        while (true) {
            for (int i = 0; i < n; i++) {
                if (strs[i].length() == prefix) {
                    return sb.toString();
                }

                char pchar = strs[Math.max(0, i - 1)].charAt(prefix);
                char cchar = strs[i].charAt(prefix);

                if (pchar != cchar) {
                    return sb.toString();
                }
            }

            sb.append(strs[0].charAt(prefix));
            prefix++;
        }
    }
}

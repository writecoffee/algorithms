import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 *
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/restore-ip-addresses/}
 *
 */
public class dfs_restore_ip_addresses
{
    public List<String> restoreIpAddresses(String s)
    {
        List<String> result = new ArrayList<>();
        explore(s.toCharArray(), 0, s.length(), new Stack<>(), result);
        return result;
    }

    private void explore(char[] sChars, int iStart, int n, Stack<Integer> path, List<String> result)
    {
        if (iStart == n && path.size() == 4) {
            result.add(convert(path));
            return;
        } else if (iStart == n) {
            return;
        } else if (path.size() > 4) {
            return;
        }

        int sectionVal = 0;
        for (int i = iStart; i < n; i++) {
            sectionVal = sectionVal * 10 + (sChars[i] - '0');

            if (sectionVal > 255) {
                break;
            }

            path.push(sectionVal);
            explore(sChars, i + 1, n, path, result);
            path.pop();

            if (i == iStart && sChars[i] == '0') {
                break;
            }
        }
    }

    private String convert(Stack<Integer> path)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < path.size(); i++) {
            if (i > 0) {
                sb.append('.');
            }
            sb.append(path.get(i));
        }

        return sb.toString();
    }
}

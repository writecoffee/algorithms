import java.util.ArrayList;
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
public class dfs_restore_ip_addresses {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        explore(s, s.length(), new Stack<String>(), 0, result);
        return result;
    }

    private void explore(String s, int n, Stack<String> path, int i, ArrayList<String> result) {
        if (i == n && path.size() == 4) {
            result.add(parseIp(new ArrayList<String>(path)));
            return;
        } else if (i < n && path.size() == 4) {
            return;
        }

        for (int end = i + 1; end <= i + 3 && end <= n; ++end) {
            String t = s.substring(i, end);

            if (Integer.parseInt(t) <= 255 && (t.length() == 1 || !t.startsWith("0"))) {
                path.push(t.toString());
                explore(s, n, path, end, result);
                path.pop();
            }
        }
    }

    private String parseIp(ArrayList<String> sections) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; ++i) {
            sb.append(sections.get(i));
            sb.append('.');
        }

        return sb.append(sections.get(3)).toString();
    }
}
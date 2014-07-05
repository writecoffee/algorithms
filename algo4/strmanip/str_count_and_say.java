/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 
 * 11 is read off as "two 1s" or 21.
 * 
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/count-and-say/}
 *
 */
public class str_count_and_say {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(1);

        for (int i = 1; i < n; ++i) {
            StringBuilder t = new StringBuilder();
            int count = 1, m = sb.length();

            for (int j = 0; j < m - 1; ++j) {
                if (sb.charAt(j) != sb.charAt(j + 1)) {
                    t.append(count).append(sb.charAt(j));
                    count = 1;
                } else {
                    count++;
                }
            }

            sb = t.append(count).append(sb.charAt(m - 1));
        }

        return sb.toString();
    }
}
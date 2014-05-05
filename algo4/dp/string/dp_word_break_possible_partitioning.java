package string;

import java.util.Set;

public class dp_word_break_possible_partitioning {
    /**
     * R(i): is true only when there is a j from 0 to i - 1 (inclusively),
     *       s.substring(j, i) is in dictionary and R(j) holds.
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; ++i) {
            for (int j = i; j >= 0; --j) {
                if (dict.contains(s.substring(j, i + 1)) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
}
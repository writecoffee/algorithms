import java.util.Set;

public class word_break {
    /**
     * R(i): is true only when there is a j from 0 to i - 1 (inclusively),
     *       s.substring(j, i) is in dictionary and R(j) holds.
     */
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
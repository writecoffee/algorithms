package uniqueways;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * 
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * 
 * The number of ways decoding "12" is 2.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/decode-ways/}
 *
 */
public class dp_unique_message_decoding_ways {
    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0 || s.charAt(0) == '0') {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < n; ++i) {
            char cC = s.charAt(i);
            char pC = s.charAt(i - 1);

            if (cC == '0') {
                if (pC != '1' && pC != '2') {
                    return 0;
                } else {
                    dp[i + 1] = dp[i - 1];
                }
            } else {
                int val = Integer.parseInt(s.substring(i - 1, i + 1));

                if (val >= 11 && val <= 26) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            }
        }

        return dp[n];
    }
}
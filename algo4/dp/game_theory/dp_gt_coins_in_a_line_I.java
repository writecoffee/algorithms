package game_theory;

/**
 * There are n coins in a line. Two players take turns to take one or two coins
 * from right side until there are no more coins left. The player who take the
 * last coin wins.
 *
 * Could you please decide the first play will win or lose?
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * n = 1, return true.
 *
 * n = 2, return true.
 *
 * n = 3, return false.
 *
 * n = 4, return true.
 *
 * n = 5, return true.
 *
 * Challenge O(n) time and O(1) memory
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/coins-in-a-line/}
 *
 */
public class dp_gt_coins_in_a_line_I
{
    public boolean firstWillWin(int n)
    {
        boolean[] dp = new boolean[Math.max(6, n + 1)];
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;
        dp[4] = true;
        dp[5] = true;

        for (int i = 6; i <= n; i++) {
            dp[i] = (dp[i - 2] && dp[i - 3]) || (dp[i - 3] && dp[i - 4]);
        }

        return dp[n];
    }
}

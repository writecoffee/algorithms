package game_theory;

/**
 * There are n coins with different value in a line. Two players take turns to
 * take one or two coins from left side until there are no more coins left. The
 * player who take the coins with the most value wins.
 *
 * Could you please decide the first player will win or lose?
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given values array A = [1,2,2], return true.
 *
 * Given A = [1,2,4], return false.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/coins-in-a-line-ii/}
 * [Difficulty] - Medium
 *
 */
public class dp_gt_coins_in_a_line_II
{
    public boolean firstWillWin(int[] values)
    {
        int sum = 0;
        for (int v : values) {
            sum += v;
        }

        int n = values.length;
        if (n <= 2) {
            return true;
        }

        int[] dp = new int[n + 1];
        dp[1] = values[n - 1];
        dp[2] = values[n - 1] + values[n - 2];
        dp[3] = values[n - 2] + values[n - 3];

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(Math.min(dp[i - 2], dp[i - 3]) + values[n - i],
                             Math.min(dp[i - 3], dp[i - 4]) + values[n - i] + values[n - i + 1]);
        }

        return dp[n] * 2 > sum;
    }
}

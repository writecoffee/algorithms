package game_theory;

/**
 * There are n coins in a line. Two players take turns to take a coin from one
 * of the ends of the line until there are no more coins left. The player with
 * the larger amount of money wins.
 *
 * Could you please decide the first player will win or lose?
 *
 * Example
 *
 * Given array A = [3,2,2], return true.
 *
 * Given array A = [1,2,4], return true.
 *
 * Given array A = [1,20,4], return false.
 *
 * Challenge
 *
 * Follow Up Question:
 *
 * If n is even. Is there any hacky algorithm that can decide whether first
 * player will win or lose in O(1) memory and O(n) time?
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/coins-in-a-line-iii/}
 * [Difficulty] - Hard
 *
 */
public class dp_gt_coins_in_a_line_III
{
    /**
     * State: f[x][y]: There are [x, y] coins remaining, the most value the first player can get.
     *
     * f[x][y] = max(min(f[x + 2][y], f[x + 1][y - 1]) + a[x],
     *               min(f[x][y - 2], f[x + 1][y - 1]) + a[y])
     *
     * initialize:
     * f[x][x] = a[x],
     * f[x][x + 1] = max(a[x], a[x + 1])
     *
     * answer: f[0][n]
     *
     */
    public boolean firstWillWin(int[] values)
    {
        int n = values.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = values[i];
        }

        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(values[i], values[i + 1]);
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i <= n - k; i++) {
                dp[i][i + k - 1] = Math.max(Math.min(dp[i + 2][i + k - 1], dp[i + 1][i + k - 2]) + values[i],
                                            Math.min(dp[i + 1][i + k - 2], dp[i][i + k - 3]) + values[i + k - 1]);
            }
        }

        int sum = 0;
        for (int v : values) {
            sum += v;
        }

        return dp[0][n - 1] * 2 > sum;
    }
}

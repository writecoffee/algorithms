package number_theory;

/**
 * Given a positive integer n, find the least number of perfect square numbers
 * (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13,
 * return 2 because 13 = 4 + 9.
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/perfect-squares/}
 *
 */
public class math_nt_perfect_square
{
    public int numSquares(int n)
    {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 0; j < i; j++) {
                int sqrRoot = (int) Math.sqrt(i - j);

                if (sqrRoot * sqrRoot == i - j) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n];
    }

    public int numSquaresImproved(int n)
    {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = 100000;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }

        return dp[n];
    }
}

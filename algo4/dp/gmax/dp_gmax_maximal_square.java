package gmax;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest
 * square containing all 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Return 4.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/maximal-square/}
 *                {@linkplain http://www.lintcode.com/en/problem/maximal-square/}
 * [Difficulty] - Medium
 *
 */
public class dp_gmax_maximal_square
{
    public int maximalSquare(char[][] matrix)
    {
        int m = matrix.length;

        if (m == 0) {
            return 0;
        }

        int n = matrix[0].length;

        int[][] dpUp = new int[m][n],
                dpLeft = new int[m][n],
                dpSquare = new int[m][n];

        int gMax = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int point = matrix[i][j] - '0',
                    py = Math.max(i - 1, 0),
                    px = Math.max(j - 1, 0);

                if (point > 0) {
                    dpUp[i][j] = dpUp[py][j] + point;
                    dpLeft[i][j] = dpLeft[i][px] + point;

                    int edge = Math.min(dpSquare[py][px] + 1, Math.min(dpUp[i][j], dpLeft[i][j]));

                    dpSquare[i][j] = edge;
                    gMax = Math.max(gMax, edge * edge);
                }
            }
        }

        return gMax;
    }

    /**
     * dp(i, j) represents the length of the square whose lower-right corner is
     * located at (i, j).
     *
     * dp(i, j) = min{ dp(i-1, j-1), dp(i-1, j), dp(i, j-1) }
     *
     */
    public int maximalSquareThoughEvoluted(char[][] a)
    {
        if (a == null || a.length == 0 || a[0].length == 0) {
            return 0;
        }

        int gMax = 0,
            n = a.length,
            m = a[0].length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1],
                               Math.min(dp[i - 1][j],
                                        dp[i][j - 1])) + 1;

                    gMax = Math.max(gMax, dp[i][j]);
                }
            }
        }

        return gMax * gMax;
    }

    public int maxSquare(int[][] matrix)
    {
        int m = matrix.length,
            n = matrix[0].length;

        int[][] dp = new int[2][n + 1];
        int rd = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == 1) {
                    int crow = i % 2,
                        prow = (i - 1) % 2;

                    dp[crow][j] = Math.min(dp[prow][j - 1],
                                  Math.min(dp[prow][j],
                                           dp[crow][j - 1])) + 1;

                    rd = Math.max(rd, dp[crow][j]);

                /*
                 * This is the tricky part. Since we are reusing
                 * the rows as memorization, we need to clear them
                 * off before moving onto next row.
                 */
                } else {
                    dp[i % 2][j] = 0;
                }
            }
        }

        return rd * rd;
    }
}

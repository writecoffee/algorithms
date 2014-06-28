package uniqueways;

/**
 * Given a value N, if we want to make change for N cents, and we have infinite
 * supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we
 * make the change? The order of coins doesn’t matter.
 * 
 * For example, for N = 4 and S = {1,2,3}, there are four solutions:
 * 
 * {1,1,1,1}, {1,1,2}, {2,2}, {1,3}.
 * 
 * So output should be 4.
 * 
 * For N = 10 and S = {2, 5, 3, 6}, there are five solutions:
 * 
 * {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
 * 
 * So the output should be 5.
 *
 * [Difficulty] - Medium
 * [Source]     - snapchat interview,
 *                {@linkplain http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/}
 * 
 */
public class dp_unique_coin_change_ways {
    /**
     * We can first think of it as a depth-first-search problem, given
     * denomination set (sorted in ascending order) and target value V,
     * we could either choose the current maximum denomination or not,
     * then we recurse into these two branches respectively.
     * 
     * If current target value is equal to 0, we found a coin change way.
     * If current target value is smaller than 0, we back track to upper
     * problem.
     * 
     * There are overlapping sub-problems and hence we could use a dynamic
     * programming approach to build the things up in a bottom-up manner.
     * 
     * R(v, j) = { R(v, j - 1)                      (if d[j] > v)
     *             R(v - d[j], j) + R(v, j - 1)     (if d[j] <= v)
     *           }
     * 
     */
    public int count(int[] denomination, int value) {
        int n = denomination.length;
        int[][] dp = new int[value + 1][n + 1];

        for (int i = 0; i < n + 1; ++i) {
            dp[0][i] = 1;
        }

        for (int j = 1; j < value + 1; ++j) {
            dp[j][0] = 0;
        }

        for (int v = 1; v <= value; ++v) {
            for (int j = 1; j <= n; ++j) {
                if (denomination[j - 1] > v) {
                    dp[v][j] = dp[v][j - 1];
                } else {
                    dp[v][j] = dp[v][j - 1] + dp[v - denomination[j - 1]][j];
                }
            }
        }

        return dp[value][n];
    }

    public int count2(int[] denomination, int value) {
        int[] dp = new int[value + 1];
        dp[0] = 1;
        int n = denomination.length;

        for (int i = 0; i < n; ++i) {
            for (int j = denomination[i]; j <= value; ++j) {
                dp[j] += dp[j - denomination[i]];
            }
        }

        return dp[value];
    }
}
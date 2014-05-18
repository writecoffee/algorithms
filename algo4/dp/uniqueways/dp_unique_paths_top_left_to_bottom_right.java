package uniqueways;

public class dp_unique_paths_top_left_to_bottom_right {
    public static int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];

        for (int i = 0; i < m; i++) {
            mem[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            mem[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
            }
        }

        return mem[m - 1][n - 1];
    }

    public static int uniquePathsImproved(int m, int n) {
        int[][] mem = new int[2][n];

        for (int i = 0; i < n; i++) {
            mem[0][i] = 1;
        }
        mem[1][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mem[i % 2][j] = mem[(i - 1) % 2][j] + mem[i % 2][j - 1];
            }
        }

        return mem[(m - 1) % 2][n - 1];
    }

    public static int uniquePathsOptimized(int m, int n) {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            dp[0] = 1;

            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
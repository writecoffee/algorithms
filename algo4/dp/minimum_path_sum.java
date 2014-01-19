public class minimum_path_sum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] table = new int[m][n];

        table[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            table[0][i] = grid[0][i] + table[0][i - 1];
        }

        for (int j = 1; j < m; j++) {
            table[j][0] = grid[j][0] + table[j - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                table[i][j] = Math.min(table[i - 1][j], table[i][j - 1]) + grid[i][j];
            }
        }

        return table[m - 1][n - 1];
    }

    public static int minPathSumImprov(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] table = new int[n];

        table[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            table[i] = grid[0][i] + table[i - 1];
        }

        for (int i = 1; i < m; i++) {
            table[0] += grid[i][0];

            for (int j = 1; j < n; j++) {
                table[j] = Math.min(table[j - 1], table[j]) + grid[i][j];
            }
        }

        return table[n - 1];
    }

    public static void main(String[] args) {

    }
}
public class unique_paths {

    public static int uniquePaths(int m, int n) {
        int[][] mem = new int[m][n];

        for (int i = 0; i < m; i++) {
            mem[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            mem[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mem[i][j] = mem[i - 1][j] + mem[i][j - 1];
            }
        }

        return mem[m - 1][n - 1];
    }

    public static void main(String[] args) {
        uniquePaths(3, 2);
    }
}
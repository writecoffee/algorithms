package memorization_search;

/**
 * Give you an integer matrix (with row size n, column size m)，find the longest increasing
 * continuous subsequence in this matrix. (The definition of the longest increasing continuous
 * subsequence here can start at any row or column and go up/down/right/left any direction).
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given a matrix:
 *
 * [
 *   [1 ,2 ,3 ,4 ,5],
 *   [16,17,24,23,6],
 *   [15,18,25,22,7],
 *   [14,19,20,21,8],
 *   [13,12,11,10,9]
 * ]
 * return 25
 *
 * Challenge
 * O(nm) time and memory.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence-ii/}
 * [Difficulty] - Medium
 *
 */
public class dp_ms_longest_increasing_continuous_subsequence_II
{
    public int longestIncreasingContinuousSubsequenceII(int[][] array)
    {
        if (array.length == 0 || array[0].length == 0) {
            return 0;
        }

        int m = array.length, n = array[0].length;
        int[][] visited = new int[m][n];
        int[][] dp = new int[m][n];
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int local = search(i, j, m, n, array, visited, dp);
                result = Math.max(result, local);
            }
        }

        return result;
    }

    private int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    private int search(int i, int j, int m, int n, int[][] matrix, int[][] visited, int[][] dp)
    {
        if (visited[i][j] == 1) {
            return dp[i][j];
        }

        int local = 0;
        visited[i][j] = -1;

        for (int[] dir : dirs) {
            int nx = dir[0] + j;
            int ny = dir[1] + i;

            if (nx < 0 || nx == n || ny < 0 || ny == m || visited[ny][nx] == -1 || matrix[i][j] >= matrix[ny][nx]) {
                continue;
            }

            local = Math.max(local, search(ny, nx, m, n, matrix, visited, dp));
        }

        visited[i][j] = 1;
        dp[i][j] = local + 1;
        return local + 1;
    }
}

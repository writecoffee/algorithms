/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 *
 * Example 1:
 *
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 *
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/number-of-islands/}
 *
 */
public class dfs_count_islands
{
    public int numIslands(char[][] grid)
    {
        if (grid.length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length, count = 0;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dfs(grid, m, n, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean dfs(char[][] grid, int m, int n, int i, int j)
    {
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        } else if (grid[i][j] == '0') {
            return false;
        }

        grid[i][j] = '0';

        dfs(grid, m, n, i, j - 1);
        dfs(grid, m, n, i, j + 1);
        dfs(grid, m, n, i - 1, j);
        dfs(grid, m, n, i + 1, j);

        return true;
    }
}

import java.util.Stack;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * 
 *     X X X X
 *     X O O X
 *     X X O X
 *     X O X X
 * 
 * After running your function, the board should be:
 * 
 *     X X X X
 *     X X X X
 *     X X X X
 *     X O X X
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain http://oj.leetcode.com/problems/surrounded-regions/}
 * 
 */
public class fill_surrounded_regions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; ++i) {
            explore(i, 0, board, m, n);
            explore(i, n - 1, board, m, n);
        }

        for (int i = 1; i < n - 1; ++i) {
            explore(0, i, board, m, n);
            explore(m - 1, i, board, m, n);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = board[i][j] == 'V' ? 'O' : 'X';
            }
        }
    }

    private void explore(int row, int col, char[][] board, int m, int n) {
        if (row < 0 || row == m || col < 0 || col == n || board[row][col] == 'X' || board[row][col] == 'V') {
            return;
        }

        board[row][col] = 'V';
        explore(row - 1, col, board, m, n);
        explore(row + 1, col, board, m, n);
        explore(row, col - 1, board, m, n);
        explore(row, col + 1, board, m, n);
    }

    @SuppressWarnings("unused")
    private void exploreNonrecur(int i, int j, char[][] board, int m, int n) {
        if (board[i][j] != 'O') {
            return;
        }

        Stack<Integer> stkRow = new Stack<Integer>();
        Stack<Integer> stkCol = new Stack<Integer>();
        stkRow.push(i);
        stkCol.push(j);

        while (!stkRow.isEmpty()) {
            int row = stkRow.pop();
            int col = stkCol.pop();

            if (!(row < 0 || row == m || col < 0 || col == n || board[row][col] == 'X' || board[row][col] == 'V')) {
                board[row][col] = 'V';
                stkRow.push(row - 1);
                stkCol.push(col);
                stkRow.push(row + 1);
                stkCol.push(col);
                stkRow.push(row);
                stkCol.push(col - 1);
                stkRow.push(row);
                stkCol.push(col + 1);
            }
        }
    }
}
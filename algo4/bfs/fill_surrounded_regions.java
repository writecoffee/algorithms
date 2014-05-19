import java.util.LinkedList;
import java.util.Queue;
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
 * http://oj.leetcode.com/problems/surrounded-regions/
 * 
 */
public class fill_surrounded_regions {
    public void solveFromBorder(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            exploreBFS(board, i, 0);
        }

        for (int i = 0; i < m; ++i) {
            exploreBFS(board, i, n - 1);
        }

        for (int i = 0; i < n; ++i) {
            exploreBFS(board, 0, i);
        }

        for (int i = 0; i < n; ++i) {
            exploreBFS(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'V' ? 'O' : 'X';
            }
        }
    }

    private void exploreBFS(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        Queue<Integer> rowQ = new LinkedList<Integer>();
        Queue<Integer> colQ = new LinkedList<Integer>();
        rowQ.add(i);
        colQ.add(j);

        while (!rowQ.isEmpty()) {
            int row = rowQ.poll();
            int col = colQ.poll();

            if (row < 0 || col < 0 || row == m || col == n) {
                continue;
            } else if (board[row][col] != 'O') {
                continue;
            } else {
                board[row][col] = 'V';
            }

            rowQ.add(row - 1);
            colQ.add(col);

            rowQ.add(row + 1);
            colQ.add(col);

            rowQ.add(row);
            colQ.add(col - 1);

            rowQ.add(row);
            colQ.add(col + 1);
        }
    }

    @SuppressWarnings("unused")
    private void exploreDFS(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        Stack<Integer> rowS = new Stack<Integer>();
        Stack<Integer> colS = new Stack<Integer>();
        rowS.push(i);
        colS.push(j);

        while (!rowS.isEmpty()) {
            int row = rowS.pop();
            int col = colS.pop();

            if (row < 0 || row == m || col < 0 || col == n) {
                continue;
            } else if (board[row][col] == 'X' || board[row][col] == 'V') {
                continue;
            } else {
                board[row][col] = 'V';
            }

            rowS.push(row - 1);
            colS.push(col);

            rowS.push(row + 1);
            colS.push(col);

            rowS.push(row);
            colS.push(col - 1);

            rowS.push(row);
            colS.push(col + 1);
        }
    }
}
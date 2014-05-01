import java.util.ArrayList;

public class n_queens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }

        explore(n, 0, 0, 0, 0, board, result);
        return result;
    }

    private void explore(int n, int i, int colMask, int ldMask, int rdMask, char[][] board, ArrayList<String[]> result) {
        if (i == n) {
            result.add(convert(board));
            return;
        }

        int mask = colMask | ldMask | rdMask;
        for (int j = 0; j < n; ++j) {
            int p = 1 << j;

            if ((p & mask) == 0) {
                board[i][n - 1 - j] = 'Q';
                explore(n, i + 1, p | colMask, (p | ldMask) << 1, (p | rdMask) >> 1, board, result);
                board[i][n - 1 - j] = '.';
            }
        }
    }

    private String[] convert(char[][] board) {
        int n = board.length;
        String[] result = new String[n];

        for (int i = 0; i < n; ++i) {
            result[i] = new String(board[i].clone());
        }

        return result;
    }
}
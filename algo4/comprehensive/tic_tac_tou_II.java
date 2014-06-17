/**
 * Design a tic-tac-tou game state checking routine for a game such that
 * the routine is O(1) time complexity.
 * 
 * Now the limitation is that we don't want to use any other persistent
 * space where reside in memory for the entire game run.
 * 
 * O(n * n) time complexity is acceptable.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain CC150-17.2}
 *
 */
public class tic_tac_tou_II {
    private enum State {
        O_WIN, X_WIN, DRAW, INVALID_MOVE, GO_ON
    }

    public State check(char[][] board) {
        int n = board.length;

        int[][] record = new int[2][8];
        int left = 3 * 3;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] != 0) {
                    int player = board[i][j] == 'O' ? 0 : 1;

                    if (++record[player][i] == n || ++record[player][n + j] == n) {
                        return player == 0 ? State.O_WIN : State.X_WIN;
                    } else if (i == j && ++record[player][n + n] == n) {
                        return player == 0 ? State.O_WIN : State.X_WIN;
                    } else if (i + j == n - 1 && ++record[player][n + n + 1] == n) {
                        return player == 0 ? State.O_WIN : State.X_WIN;
                    } else if (--left == 0) {
                        return State.DRAW;
                    }
                }
            }
        }

        return State.GO_ON;
    }
}
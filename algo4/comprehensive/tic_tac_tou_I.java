/**
 * Design a tic-tac-tou game state checking routine for a game such that
 * the routine is O(1) time complexity.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain CC150-17.2}
 *
 */
public class tic_tac_tou_I {
    private static int[][] record = new int[2][8];
    private static int left = 3 * 3;

    private enum Player {
        O('O'), X('X');

        public final Character c;

        private Player(Character _str) {
            c = _str;
        }
    }

    private enum State {
        O_WIN, X_WIN, DRAW, INVALID_MOVE, GO_ON
    }

    public State check(char[][] board, int row, int col, Player player) {
        int n = board.length;

        if (board[row][col] == 0) {
            if (++record[player.ordinal()][row] == n
             || ++record[player.ordinal()][n + col] == n
             || ++record[player.ordinal()][n + n] == n
             || ++record[player.ordinal()][n + n + 1] == n) {
                return State.values()[player.ordinal()];
            }

            if (--left == 0) {
                return State.DRAW;
            }

            board[row][col] = player.c;
        }

        return State.GO_ON;
    }
}
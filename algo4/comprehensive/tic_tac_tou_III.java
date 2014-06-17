/**
 * Design a tic-tac-tou game state checking routine for a game such that the routine
 * is O(1) time complexity.
 * 
 * Now let's assume we are server and serving a lot of clients. Try to devise an
 * algorithm to beat the first solution in terms of space complexity.
 * 
 * We don't need to store the board, because there will be only 3^9 different
 * game boards. And hence we can convert the game board to a 3-base representation
 * and preprocessing is required.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain CC150-17.2}
 *
 */
public class tic_tac_tou_III {
    private static State[] result = new State[(int) Math.pow(3.0, 9.0)];
    private int state;
    private boolean[] occupied;

    private enum State {
        O_WIN, X_WIN, DRAW, GO_ON
    }

    public static void preprocess(char[][] board) {
        int n = board.length;
        explore(n, board, -1, 0);
    }

    private static void explore(int n, char[][] board, int i, int sum) {
        if (++i == n * n) {
            result[sum] = checkState(n, board);
        } else {
            int row = i / n, col = i % n;

            sum *= 3;
            explore(n, board, i, sum);

            board[row][col] = 'O';
            explore(n, board, i, ++sum);

            board[row][col] = 'X';
            explore(n, board, i, ++sum);

            sum /= 3;
            board[row][col] = 0;
        }

        i--;
    }

    private static State checkState(int n, char[][] board) {
        int[][] record = new int[2][8];
        int left = n * n;

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

    public State hasWon(int n, int row, int col, int player) {
        assert player == 1 || player == 2;

        int bitPos = row * n + col;

        if (!occupied[bitPos]) {
            for (int i = 0; i < bitPos; ++i) {
                player *= 3;
            }

            state += player;
            occupied[bitPos] = true;
        }

        return result[state];
    }
}
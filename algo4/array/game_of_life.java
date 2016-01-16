/**
 * According to the Wikipedia's article:
 *
 * "The Game of Life, also known simply as Life, is a cellular automaton devised
 * by the British mathematician John Horton Conway in 1970."
 *
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 *
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by
 *    under-population.
 *
 * 2. Any live cell with two or three live neighbors lives on to
 *    the next generation.
 *
 * 3. Any live cell with more than three live neighbors dies,
 *    as if by over-population.
 *
 * 4. Any dead cell with exactly three live neighbors
 *    becomes a live cell, as if by reproduction. Write a function to compute the
 *    next state (after one update) of the board given its current state.
 *
 * Follow up:
 *
 * 1. Could you solve it in-place? Remember that the board needs to be updated
 *    at the same time: You cannot update some cells first and then use their
 *    updated values to update other cells.
 *
 * 2. In this question, we represent the board using a 2D array. In principle,
 *    the board is infinite, which would cause problems when the active area
 *    encroaches the border of the array. How would you address these problems?
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/game-of-life/}
 * [Difficulty] - Medium
 *
 */
public class game_of_life
{
    /*
     * Move        ->
     *       /  |  \
     *      v   v   v
     *
     * Index move left, then down
     *
     */
    private int[][] direction = new int[][] { { 1, 0 }, { 1, 1 }, { 1, -1 }, { 0, 1 } };

    public void gameOfLife(int[][] board)
    {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : direction) {
                    int x = dir[1] + j;
                    int y = dir[0] + i;

                    if (x < 0 || y < 0 || x == n || y == m) {
                        continue;
                    }

                    if (board[y][x] % 2 == 1) {
                        board[i][j] += 2;
                    }

                    if (board[i][j] % 2 == 1) {
                        board[y][x] += 2;
                    }
                }

                if (board[i][j] > 4 && board[i][j] < 8) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }
}

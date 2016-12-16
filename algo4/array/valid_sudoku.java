
/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with
 * the character '.'.
 *
 *
 * A partially filled sudoku which is valid.
 *
 * Note:
 *
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the
 * filled cells need to be validated.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/valid-sudoku/}
 * [Difficulty] - Medium
 *
 */
public class valid_sudoku
{
    public boolean isValidSudoku(char[][] board)
    {
        for (int i = 0; i < 9; i++) {
            boolean[] rowVisited = new boolean[9];
            boolean[] colVisited = new boolean[9];
            boolean[] gridVisited = new boolean[9];

            for (int j = 0; j < 9; j++) {
                int rowChar = board[j][i] - '1';
                int colChar = board[i][j] - '1';
                int gridRowIndex = i / 3 * 3 + j / 3;
                int gridColIndex = i % 3 * 3 + j % 3;
                int gridChar = board[gridRowIndex][gridColIndex] - '1';

                if (board[j][i] != '.') {
                    if (rowVisited[rowChar]) {
                        return false;
                    }
                    rowVisited[rowChar] = true;
                }

                if (board[i][j] != '.') {
                    if (colVisited[colChar]) {
                        return false;
                    }
                    colVisited[colChar] = true;
                }

                if (board[gridRowIndex][gridColIndex] != '.') {
                    if (gridVisited[gridChar]) {
                        return false;
                    }
                    gridVisited[gridChar] = true;
                }
            }
        }

        return true;
    }
}

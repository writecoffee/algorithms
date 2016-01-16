
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
    private boolean isValid(char c, boolean[] visited)
    {
        if (c == '.') {
            return true;
        }

        if (visited[c - '1']) {
            return false;
        }

        visited[c - '1'] = true;
        return true;
    }

    public boolean isValidSudoku(char[][] board)
    {
        if (board.length != 9) {
            return false;
        }

        if (board[0].length != 9) {
            return false;
        }

        for (int i = 0; i < 9; ++i) {
            boolean[] visited = new boolean[9];

            for (int j = 0; j < 9; ++j) {
                if (!isValid(board[i][j], visited)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; ++i) {
            boolean[] visited = new boolean[9];

            for (int j = 0; j < 9; ++j) {
                if (!isValid(board[j][i], visited)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; ++i) {
            boolean[] visited = new boolean[9];

            int startRow = i / 3 * 3,
                startCol = i % 3 * 3;

            for (int j = 0; j < 9; ++j) {
                if (!isValid(board[startRow + j / 3][startCol + j % 3], visited)) {
                    return false;
                }
            }
        }

        return true;
    }
}

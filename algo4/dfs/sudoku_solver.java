import java.util.ArrayDeque;
import java.util.Deque;

public class sudoku_solver {
    public class Pair {
        public int row;
        public int col;

        public Pair(int a, int b) {
            row = a;
            col = b;
        }
    }

    public void solveSudoku(char[][] board) {
        Deque<Pair> availableCells = findAllEmptyGrid(board);
        explore(board, availableCells.pollFirst(), availableCells);
    }

    /**
     * Check whether the board is still valid after fill in a cell.
     * Only need to check the current row/column/box.
     */
    private boolean isValidSudoku(char[][] board, int row, int col) {
        int n = 9;

        for (int i = 0; i < n; i++) {
            if (i != col && board[row][col] == board[row][i]) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != row && board[row][col] == board[i][col]) {
                return false;
            }
        }

        int rStart = row / 3 * 3;
        int cStart = col / 3 * 3;
        for (int i = 0, ri = rStart, ci = cStart; i < n; i++, ri = rStart + i / 3, ci = cStart + i % 3) {
            if (ri != row && ci != col && board[row][col] == board[ri][ci]) {
                return false;
            }
        }

        return true;
    }

    private boolean explore(char[][] board, Pair newCell, Deque<Pair> emptyGrids) {
        for (int i = 1; i < 10; i++) {
            board[newCell.row][newCell.col] = (char) ('0' + i);

            if (isValidSudoku(board, newCell.row, newCell.col)) {
                if (emptyGrids.isEmpty() || explore(board, emptyGrids.pollFirst(), emptyGrids)) {
                    return true;
                }
            }

            board[newCell.row][newCell.col] = '.';
        }

        emptyGrids.addFirst(newCell);
        return false;
    }

    private Deque<Pair> findAllEmptyGrid(char[][] board) {
        Deque<Pair> result = new ArrayDeque<Pair>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    result.add(new Pair(i, j));
                }
            }
        }

        return result;
    }
}
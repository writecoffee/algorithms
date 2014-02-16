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

        public String toString() {
            return "(" + row + ", " + col + ")";
        }

        public boolean equals(Pair pp) {
            return (pp != null && row == pp.row && col == pp.col);
        }
    }

    /**
     * Check whether the board is still valid after fill in a cell. Only need to check the current
     * row/column/box
     */
    public boolean isValidSudoku(char[][] board, Pair cell) {
        int boxLength = (int) Math.sqrt(board.length);

        for (int i = 0; i < board.length; i++) {
            if (i != cell.col && board[cell.row][cell.col] == board[cell.row][i]) {
                return false;
            }

            if (i != cell.row && board[i][cell.col] == board[cell.row][cell.col]) {
                return false;
            }

            int boxRow = cell.row / boxLength * boxLength + i / boxLength;
            int boxCol = cell.col / boxLength * boxLength + i % boxLength;
            if (boxRow != cell.row && boxCol != cell.col && board[boxRow][boxCol] == board[cell.row][cell.col]) {
                return false;
            }
        }

        return true;
    }

    public boolean helper(char[][] board, Pair newCell, Deque<Pair> availableCells) {
        for (int i = 1; i < 10; i++) {
            board[newCell.row][newCell.col] = (char) ('0' + i);
            if (isValidSudoku(board, newCell)
                            && (availableCells.isEmpty() || helper(board, availableCells.pollFirst(), availableCells))) {
                return true;
            } else {
                board[newCell.row][newCell.col] = '.';
            }
        }

        availableCells.addFirst(newCell);
        return false;
    }

    public void solveSudoku(char[][] board) {
        Deque<Pair> availableCells = findAllAvailableCells(board);
        helper(board, availableCells.pollFirst(), availableCells);
    }

    private Deque<Pair> findAllAvailableCells(char[][] board) {
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
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 *
 * Empty cells are indicated by the character '.'.
 *
 * You may assume that there will be only one unique solution.
 *
 *
 * A sudoku puzzle...
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/sudoku-solver/}
 * [Difficulty] - Hard
 *
 */
public class sudoku_solver
{
    public class Pair
    {
        public int row;
        public int col;

        public Pair(int a, int b) {
            row = a;
            col = b;
        }
    }

    public void solveSudoku(char[][] board)
    {
        int[] masks = new int[27];
        Deque<Pair> availableCells = findAllEmptyGrid(board, masks);
        explore(board, availableCells.pollFirst(), availableCells, masks);
    }

    /**
     * Check whether the board is still valid after fill in a cell. Only need to
     * check the current row/column/box.
     */
    private boolean isValidSudoku(int zeroBasedNumber, int row, int col, int[] masks)
    {
        int rowMask = masks[row];
        int colMask = masks[9 + col];
        int subgridMask = masks[18 + row / 3 * 3 + col / 3];
        int numberFlag = 1 << zeroBasedNumber;

        return (rowMask & numberFlag) == 0 && (colMask & numberFlag) == 0 && (subgridMask & numberFlag) == 0;
    }

    private void updateMask(int zeroBasedNumber, int row, int col, int[] masks, boolean setOrNotSet)
    {
        int subGridIndex = row / 3 * 3 + col / 3;

        if (setOrNotSet) {
            int numberFlag = 1 << zeroBasedNumber;

            masks[row] |= numberFlag;
            masks[9 + col] |= numberFlag;
            masks[18 + subGridIndex] |= numberFlag;
        } else {
            int numberFlag = ~(1 << zeroBasedNumber);

            masks[row] &= numberFlag;
            masks[9 + col] &= numberFlag;
            masks[18 + subGridIndex] &= numberFlag;
        }
    }

    private boolean explore(char[][] board, Pair newCell, Deque<Pair> emptyGrids, int[] masks)
    {
        for (int i = 1; i < 10; i++) {

            if (isValidSudoku(i - 1, newCell.row, newCell.col, masks)) {
                board[newCell.row][newCell.col] = (char) ('0' + i);
                updateMask(i - 1, newCell.row, newCell.col, masks, true);

                if (emptyGrids.isEmpty() || explore(board, emptyGrids.pollFirst(), emptyGrids, masks)) {
                    // the first returned true will trigger producing the final
                    // solution
                    return true;
                }

                updateMask(i - 1, newCell.row, newCell.col, masks, false);
                board[newCell.row][newCell.col] = '.';
            }
        }

        emptyGrids.addFirst(newCell);
        return false;
    }

    private Deque<Pair> findAllEmptyGrid(char[][] board, int[] masks)
    {
        Deque<Pair> result = new ArrayDeque<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    result.add(new Pair(i, j));
                } else {
                    updateMask(board[i][j] - '1', i, j, masks, true);
                }
            }
        }

        return result;
    }
}

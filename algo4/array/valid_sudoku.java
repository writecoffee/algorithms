import java.util.Arrays;

public class valid_sudoku {
    private boolean isValid(char c, boolean[] numbers) {
        if (c == '.') {
            return true;
        }

        if (!(c >= '1' || c <= '9') || numbers[c - '1']) {
            return false;
        }

        numbers[c - '1'] = true;
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9) {
            return false;
        }

        if (board[0].length != 9) {
            return false;
        }

        boolean[] block = new boolean[9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (!isValid(board[i][j], block)) {
                    return false;
                }
            }
        }

        Arrays.fill(block, false);
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (!isValid(board[j][i], block)) {
                    return false;
                }
            }
        }

        Arrays.fill(block, false);
        for (int i = 0; i < 9; ++i) {
            int row = (i / 3) * 3, col = (i % 3) * 3;
            for (int j = 0; j < 9; ++j) {
                if (!isValid(board[row + j / 3][col + (j % 3)], block)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValidSudoku(int[] arr) {
        final int n = 9;

        for (int i = 0; i < n; ++i) {
            boolean[] visited = new boolean[n];

            for (int j = 0; j < n; ++j) {
                int val = arr[i * n + j];
                if (val < 1 || val > 9) {
                    return false;
                } else if (visited[val - 1]) {
                    return false;
                } else {
                    visited[val - 1] = true;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            boolean[] visited = new boolean[n];

            for (int j = 0; j < n; ++j) {
                int val = arr[i + j * n];
                if (visited[val - 1]) {
                    return false;
                } else {
                    visited[val - 1] = true;
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            boolean[] visited = new boolean[n];

            for (int j = 0; j < n; ++j) {
                int row = i / 3 * 3 + j / 3;
                int col = i % 3 * 3 + j % 3;
                int val = arr[row * n + col];
                if (visited[val - 1]) {
                    return false;
                } else {
                    visited[val - 1] = true;
                }
            }
        }

        return true;
    }
}
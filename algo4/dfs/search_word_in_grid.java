public class search_word_in_grid {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] h = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (explore(board, word, 0, i, j, h)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean explore(char[][] board, String word, int k, int i, int j, boolean[][] h) {
        int m = board.length;
        int n = board[0].length;

        if (k == word.length()) {
            return true;
        } else if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        } else if (board[i][j] != word.charAt(k) || h[i][j]) {
            return false;
        }

        h[i][j] = true;
        if (explore(board, word, k + 1, i - 1, j, h)) {
            return true;
        } else if (explore(board, word, k + 1, i + 1, j, h)) {
            return true;
        } else if (explore(board, word, k + 1, i, j - 1, h)) {
            return true;
        } else if (explore(board, word, k + 1, i, j + 1, h)) {
            return true;
        }

        h[i][j] = false;
        return false;
    }
}
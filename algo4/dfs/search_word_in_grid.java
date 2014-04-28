public class search_word_in_grid {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (explore(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean explore(char[][] board, String word, int k, int i, int j, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if (k == word.length()) {
            return true;
        } else if (i < 0 || j < 0 || i == m || j == n) {
            return false;
        } else if (board[i][j] != word.charAt(k) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if (explore(board, word, k + 1, i - 1, j, visited)) {
            return true;
        } else if (explore(board, word, k + 1, i, j - 1, visited)) {
            return true;
        } else if (explore(board, word, k + 1, i + 1, j, visited)) {
            return true;
        } else if (explore(board, word, k + 1, i, j + 1, visited)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same letter
 * cell may not be used more than once.
 * 
 * For example,
 * 
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * 
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/word-search/}
 *
 */
public class dfs_search_word_in_grid {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (explore(board, m, n, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean explore(char[][] board, int m, int n, String word, int k, int i, int j) {
        if (k == word.length()) {
            return true;
        } else if (i < 0 || j < 0 || i == m || j == n || board[i][j] != word.charAt(k)) {
            return false;
        }

        char t = board[i][j];
        board[i][j] = '#';
        if (explore(board, m, n, word, k + 1, i - 1, j)
         || explore(board, m, n, word, k + 1, i, j - 1)
         || explore(board, m, n, word, k + 1, i + 1, j)
         || explore(board, m, n, word, k + 1, i, j + 1)) {
            return true;
        }
        board[i][j] = t;

        return false;
    }
}
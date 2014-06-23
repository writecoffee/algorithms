import java.util.HashMap;

/**
 * 
 * Given a 2D board and a word, find if there is one or more than one words in the pattern set exist
 * in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells
 * are those horizontally or vertically neighboring. The same letter cell may not be used more than
 * once.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/word-search/}
 * 
 */
public class dfs_search_word_in_grid_using_trie {
    private class TrieNode {
        private final HashMap<Character, TrieNode> children;
        private boolean isEnd = false;

        private TrieNode(char _c) {
            children = new HashMap<Character, TrieNode>();
        }

        private void addChild(char c) {
            children.put(c, new TrieNode(c));
        }

        private boolean hasChild(char c) {
            return children.containsKey(c);
        }

        private TrieNode getChild(char c) {
            return children.get(c);
        }
    }

    public boolean exists(char[][] board, String[] patterns) {
        int m = board.length, n = board[0].length;

        TrieNode root = new TrieNode('*');

        for (String s : patterns) {
            preprocess(root, s);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (explore(board, m, n, root, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private void preprocess(TrieNode root, String pattern) {
        TrieNode tn = root;

        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);

            if (!tn.hasChild(c)) {
                tn.addChild(c);
            }

            tn = tn.getChild(c);
        }

        tn.isEnd = true;
    }

    private boolean explore(char[][] board, int m, int n, TrieNode tn, int i, int j) {
        if (tn.isEnd) {
            return true;
        } else if (i < 0 || j < 0 || i == m || j == n || !tn.hasChild(board[i][j])) {
            return false;
        }

        TrieNode child = tn.getChild(board[i][j]);
        char t = board[i][j];
        board[i][j] = '#';

        if (explore(board, m, n, child, i - 1, j)
         || explore(board, m, n, child, i, j - 1)
         || explore(board, m, n, child, i + 1, j)
         || explore(board, m, n, child, i, j + 1)) {
            return true;
        }

        board[i][j] = t;
        return false;
    }
}
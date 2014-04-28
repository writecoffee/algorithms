import java.util.HashMap;

public class search_word_in_grid_using_trie {
    class TrieNode {
        final HashMap<Character, TrieNode> children;
        final char c;
        public boolean isEnd = false;

        TrieNode(char _c) {
            children = new HashMap<Character, TrieNode>();
            c = _c;
        }

        void addChild(char c) {
            children.put(c, new TrieNode(c));
        }

        boolean hasChild(char c) {
            return children.containsKey(c);
        }

        TrieNode getChild(char c) {
            return children.get(c);
        }
    }

    TrieNode root = new TrieNode('*');

    public void addTrie(String pattern) {
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

    public boolean exists(char[][] board, String[] patterns) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (String s : patterns) {
            addTrie(s);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (explore(board, root, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean explore(char[][] board, TrieNode tn, int i, int j, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;

        if (tn.isEnd) {
            return true;
        } else if (i < 0 || j < 0 || i == m || j == n) {
            return false;
        } else if (!tn.hasChild(board[i][j]) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        TrieNode nxt = tn.getChild(board[i][j]);
        if (explore(board, nxt, i - 1, j, visited)) {
            return true;
        } else if (explore(board, nxt, i, j - 1, visited)) {
            return true;
        } else if (explore(board, nxt, i + 1, j, visited)) {
            return true;
        } else if (explore(board, nxt, i, j + 1, visited)) {
            return true;
        }

        visited[i][j] = false;
        return false;
    }
}
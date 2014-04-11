public class search_word_in_grid_II {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];

        void addChild(char s) {
            children[s - 'A'] = new TrieNode();
        }

        boolean hasChild(char s) {
            return children[s - 'A'] != null;
        }

        public boolean isEnd = false;
    }

    public static void addTrie(String pattern) {
        TrieNode tn = root;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (tn.children[c - 'A'] == null) {
                tn.addChild(c);
            }

            tn = tn.children[c - 'A'];
        }

        tn.isEnd = true;
    }

    static TrieNode root;

    public static boolean exists(char[][] board, String[] word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] h = new boolean[m][n];
        root = new TrieNode();

        for (String s : word) {
            addTrie(s);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (explore(board, root, i, j, h)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean explore(char[][] board, TrieNode tn, int i, int j, boolean[][] h) {
        int m = board.length;
        int n = board[0].length;

        if (tn.isEnd) {
            return true;
        } else if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        } else if (!tn.hasChild(board[i][j]) || h[i][j]) {
            return false;
        }

        h[i][j] = true;
        int index = board[i][j] - 'A';
        if (explore(board, tn.children[index], i - 1, j, h)) {
            return true;
        } else if (explore(board, tn.children[index], i + 1, j, h)) {
            return true;
        } else if (explore(board, tn.children[index], i, j - 1, h)) {
            return true;
        } else if (explore(board, tn.children[index], i, j + 1, h)) {
            return true;
        }

        h[i][j] = false;
        return false;
    }
}
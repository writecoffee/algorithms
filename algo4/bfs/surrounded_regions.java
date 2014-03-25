import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class surrounded_regions {
    public static class GridNode {
        public final int row;
        public final int col;

        public GridNode(int _row, int _col) {
            col = _col;
            row = _row;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + row + col;
            return result;
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            } else if (other == null) {
                return false;
            } else if (!(other instanceof GridNode)) {
                return false;
            }

            GridNode o = (GridNode) other;
            return row == o.row && col == o.col;
        }
    }

    public static void solveFromBorder(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            exploreBFS(board, i, 0);
        }

        for (int i = 0; i < m; ++i) {
            exploreBFS(board, i, n - 1);
        }

        for (int i = 0; i < n; ++i) {
            exploreBFS(board, 0, i);
        }

        for (int i = 0; i < n; ++i) {
            exploreBFS(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 'V' ? 'O' : 'X';
            }
        }
    }

    private static void exploreBFS(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        Queue<GridNode> q = new LinkedList<GridNode>();
        q.add(new GridNode(i, j));

        while (!q.isEmpty()) {
            GridNode node = q.poll();
            int row = node.row;
            int col = node.col;

            if (node.row < 0 || node.col < 0 || node.row == m || node.col == n) {
                continue;
            }

            if (board[row][col] != 'O') {
                continue;
            }

            board[row][col] = 'V';
            q.add(new GridNode(row - 1, col));
            q.add(new GridNode(row + 1, col));
            q.add(new GridNode(row, col - 1));
            q.add(new GridNode(row, col + 1));
        }
    }

    @SuppressWarnings("unused")
    private static void exploreDFS(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return;
        }

        if (board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'V';
        exploreDFS(board, i + 1, j);
        exploreDFS(board, i, j + 1);
        exploreDFS(board, i, j - 1);
        exploreDFS(board, i - 1, j);
    }

    public static void solveTimeout(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;
        HashSet<GridNode> visited = new HashSet<GridNode>();

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (exploreTimeout(board, i, j, visited) == 0) {
                    for (GridNode v : visited) {
                        board[v.row][v.col] = 'X';
                    }
                }

                visited.clear();
            }
        }
    }

    public static int exploreTimeout(char[][] board, int i, int j, HashSet<GridNode> visited) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) {
            return 1;
        }

        if (board[i][j] == 'X') {
            return 0;
        }

        if (visited.contains(new GridNode(i, j))) {
            return 0;
        } else {
            visited.add(new GridNode(i, j));
        }

        int result = 0;
        result += exploreTimeout(board, i - 1, j, visited);
        result += exploreTimeout(board, i, j - 1, visited);
        result += exploreTimeout(board, i + 1, j, visited);
        result += exploreTimeout(board, i, j + 1, visited);
        return result;
    }

    public static void main(String[] args) {
        solveTimeout(new char[][] { "OO".toCharArray(), "OO".toCharArray() });
    }
}
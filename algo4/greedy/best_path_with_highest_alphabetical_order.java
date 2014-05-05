import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class best_path_with_highest_alphabetical_order {
    static class Node {
        final int row;
        final int col;
        final char c;

        Node(int _row, int _col, char _c) {
            row = _row;
            col = _col;
            c = _c;
        }
    }

    public String findBestPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        Node[] array = new Node[m * n];

        for (int i = 0; i < m * n; ++i) {
            array[i] = new Node(i / n, i % n, grid[i / n][i % n]);
        }

        Arrays.sort(array, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.c - b.c;
            }
        });

        PriorityQueue<Node> pq = new PriorityQueue<Node>(m + n - 1, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.row == b.row ? a.col - b.col : a.row - b.row;
            }
        });

        for (int i = 0; i < m + n - 1; ++i) {
            Node c = array[0];

            for (int j = 0; j < m * n; ++j) {
                if (array[j] != null) {
                    c = array[j];
                    array[j] = null;
                    break;
                }
            }

            for (int j = 0; j < m * n; ++j) {
                Node t = array[j];
                if (t != null && ((t.row > c.row && t.col < c.col) || (t.row < c.row && t.col >= c.col))) {
                    array[j] = null;
                }
            }

            pq.add(c);
        }

        return convert(pq);
    }

    private String convert(PriorityQueue<Node> pq) {
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            sb.append(pq.poll().c);
        }

        return sb.toString();
    }
}
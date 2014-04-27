import java.util.Comparator;
import java.util.PriorityQueue;

public class find_k_smallest_number_in_row_col_wised_sorted_matrix {
    class GridNode {
        public final int row;
        public final int col;
        public final int val;

        GridNode(int _row, int _col, int _val) {
            row = _row;
            col = _col;
            val = _val;
        }
    }

    /**
     * Add all elements from first row to the min-heap and then "dive" into the column which
     * contains the smallest element. We need to pop k - 1 times and the result is in the 
     * last pop-action.
     * 
     * { 10, 20, 30, 40 },
     * { 15, 25, 35, 45 },
     * { 25, 29, 37, 48 },
     * { 32, 33, 39, 50 }
     * 
     */
    public int search(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        PriorityQueue<GridNode> pq = new PriorityQueue<GridNode>(k, new Comparator<GridNode>() {
            @Override
            public int compare(GridNode a, GridNode b) {
                return a.val - b.val;
            }
        });

        for (int i = 0; i < n; ++i) {
            pq.add(new GridNode(0, i, matrix[0][i]));
        }

        for (int i = 0 ; i < k - 1; ++i) {
            GridNode c = pq.poll();

            if (c.row < m - 1) {
                pq.add(new GridNode(c.row + 1, c.col, matrix[c.row + 1][c.col]));
            }
        }

        return pq.poll().val;
    }
}
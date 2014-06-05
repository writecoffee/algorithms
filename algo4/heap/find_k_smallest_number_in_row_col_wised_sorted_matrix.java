import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an n x n matrix, where every row and column is sorted in non-decreasing order. Find the
 * kth smallest element in the given 2D array.
 * 
 * For example, consider the following 2D array.
 * 
 *         10, 20, 30, 40
 *         15, 25, 35, 45
 *         24, 29, 37, 48
 *         32, 33, 39, 50
 * 
 * The 3rd smallest element is 20 and 7th smallest element is 30
 * 
 * {@linkplain http://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/}
 * 
 */
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
     * A key observation here is that the smallest element is on the upper-left corner. From that position,
     * we are pretty sure that will be the right place to start searching the k smallest number.
     * 
     * So the second smallest number could be matrix[0][1] or matrix[1][0], if matrix[1][0] is the
     * second smallest element, and matrix[0][1] is the third smallest element, next time we will have
     * three elements to compete for the fourth smallest number, like below:
     * 
     *          $ $ # . . .
     *          $ # . . . .
     *          # . . . . .
     *          . . . . . .
     * 
     * So we would have at most n elements to compete to be chosen as the next smallest and hence we
     * can reclaim a max-heap of size n to store the elements to be chosen. Now the algorithm is simple,
     * we can just add all elements in the first row then dive down into first column then first or second
     * row, so on and so forth.
     * 
     * Time Complexity: The above solution involves following steps.
     * 
     * (1) Build a min heap which takes O(n) time
     * 
     * (2) Heapify k times which takes O(kLogn) time. Therefore, overall time complexity is
     *     O(n + kLogn) time.
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
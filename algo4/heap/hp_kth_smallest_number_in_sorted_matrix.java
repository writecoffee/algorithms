import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Medium Kth Smallest Number in Sorted Matrix Show result
 *
 * Find the kth smallest number in at row and column sorted matrix.
 *
 * Example
 *
 * Given k = 4 and a matrix:
 *
 * [
 *  [1 ,5 ,7],
 *  [3 ,7 ,8],
 *  [4 ,8 ,9],
 * ]
 *
 * return 5
 *
 * Challenge
 *
 * O(k log n), n is the maximal number in width and height.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/}
 *
 */
public class hp_kth_smallest_number_in_sorted_matrix
{
    public static class Pair
    {
        int first;
        int second;

        Pair(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public int kthSmallest(int[][] matrix, int k)
    {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        if (m * n < k) {
            return -1;
        }

        Queue<Pair> q = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2)
            {
                return o1.first - o2.first;
            }
        });

        for (int i = 0; i < m; i++) {
            q.add(new Pair(matrix[i][0], i * n));
        }

        for (int i = 0; i < k - 1; i++) {
            Pair smallest = q.poll();

            int row = smallest.second / n;
            int col = smallest.second % n + 1;

            if (col < n) {
                q.add(new Pair(matrix[row][col], row * n + col));
            }
        }

        return q.poll().first;
    }
}

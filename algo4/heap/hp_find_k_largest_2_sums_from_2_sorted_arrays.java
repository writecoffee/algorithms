import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Given two sorted (in ascending order) arrays, a and b, they have the same length. Return k
 * largest two sums where numbers are picked from a and b respectively.
 * 
 * For example: 
 * 
 *    a = [1, 2, 3, 4, 5], b = [2, 4, 6, 8, 10], return [15, 14, 13, 13, 12]
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview
 * 
 */
public class hp_find_k_largest_2_sums_from_2_sorted_arrays {
    private class HeapNode implements Comparable<HeapNode> {
        private final int i;
        private final int j;
        private final int sum;

        private HeapNode(int _i, int _j, int _sum) {
            i = _i;
            j = _j;
            sum = _sum;
        }

        @Override
        public int compareTo(HeapNode o) {
            return o.sum - sum;
        }
    }

    /**
     * The key observation here is that the bigger sum must be formed by a[n - 1], b[n - 1].
     * And then which two pairs would be <= (a[n - 1], b[n - 1])? They are (a[n - 1], b[n - 2])
     * and (a[n - 2], b[n - 1]).
     * 
     * We can build a maximum heap to keep track of the biggest sum and pop it out push the
     * next 2 possible pairs into the heap again.
     * 
     * The time complexity should be O(k log k) because there are at most 2k number of numbers
     * pushed into the heap and we would pop k pairs out of the heap.
     * 
     */
    public ArrayList<Integer> findLargestSums(int[] a, int[] b, int k) {
        int n = a.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        PriorityQueue<HeapNode> pq = new PriorityQueue<HeapNode>();
        pq.add(new HeapNode(n - 1, n - 1, a[n - 1] + b[n - 1]));

        while (result.size() < k) {
            HeapNode c = pq.poll();
            result.add(c.sum);

            if (c.i > 0) {
                pq.add(new HeapNode(c.i - 1, c.j, a[c.i - 1] + b[c.j]));
            }

            if (c.j > 0) {
                pq.add(new HeapNode(c.i, c.j - 1, a[c.i] + b[c.j - 1]));
            }
        }

        return result;
    }
}
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class hp_find_k_largest_elements_in_an_unsorted_array {
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    public ArrayList<Integer> getMaxK(int[] array, int k) {
        int n = array.length;
        Queue<Integer> pq = new PriorityQueue<Integer>(n);

        for (Integer i : array) {
            pq.add(i);
        }

        return new ArrayList<Integer>(new ArrayList<Integer>(pq).subList(Math.max(0, n - k), n));
    }

    /**
     * Time: O(k log k + (n - k) log k)
     * Space: O(k)
     */
    public ArrayList<Integer> getMaxKWithMinHeap(int[] array, int k) {
        int n = array.length;
        Queue<Integer> pq = new PriorityQueue<Integer>(k);

        for (int i = 0; i < Math.min(k, n); i++) {
            pq.add(array[i]);
        }

        for (int i = k; i < n; i++) {
            if (pq.peek() < array[i]) {
                pq.poll();
                pq.add(array[i]);
            }
        }

        return new ArrayList<Integer>(pq);
    }
}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class find_k_largest_elements_in_an_unsorted_array {
    /**
     * Time: O(n log n)
     * Space: O(n)
     */
    public static ArrayList<Integer> getMaxK(int[] array, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int n = array.length;
        assert n > k;

        Queue<Integer> pq = new PriorityQueue<Integer>(n, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int i = 0; i < n; i++) {
            pq.add(array[i]);
        }

        for (int i = 0; i < k; i++) {
            result.add(pq.poll());
        }

        return result;
    }

    /**
     * Time: O(k log k + (n - k) log k)
     * Space: O(k)
     */
    public static ArrayList<Integer> getMaxKWithMinHeap(int[] array, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Integer> pq = new PriorityQueue<Integer>(k);
        int n = array.length;
        assert n > k;

        int i = 0;
        for (; i < k; i++) {
            pq.add(array[i]);
        }

        for (; i < n; i++) {
            if (pq.peek() < array[i]) {
                pq.poll();
                pq.add(array[i]);
            }
        }

        result.addAll(pq);
        Collections.reverse(result);
        return result;
    }
}
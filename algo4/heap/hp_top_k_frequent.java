import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class hp_top_k_frequent
{
    /**
     * Tries tend to be faster on average at insertion than hash tables because hash tables must
     * rebuild their index when it becomes full - a very expensive operation. Tries therefore have
     * much better bounded worst-case time costs, which is important for latency-sensitive programs.
     * 
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> counter = new HashMap<>();
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2)
            {
                return o1.getValue() - o2.getValue();
            }
        });

        for (int num : nums) {
            Integer count = counter.get(num);

            if (count == null) {
                count = 0;
            }

            counter.put(num, count + 1);
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int count = entry.getValue();

            if (i < k) {
                pq.add(entry);
            } else {
                if (pq.peek().getValue() < count) {
                    pq.poll();
                    pq.add(entry);
                }
            }

            i++;
        }

        while (!pq.isEmpty()) {
            result.add(pq.poll().getKey());
        }

        Collections.reverse(result);
        return result;
    } 
}

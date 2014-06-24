import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Given a connected graph (represented in adjacency map), compute the shortest distance
 * starting from node s.
 * 
 * [Difficulty] - Medium
 * [Source]     - Classical problem
 *
 */
public class gr_dijkstra_finding_all_shortest_distances {
    private class HeapNode implements Comparable<HeapNode> {
        private final int weight;
        private final char tail;

        public HeapNode(int _weight, char _tail) {
            weight = _weight;
            tail = _tail;
        }

        @Override
        public int compareTo(HeapNode o) {
            return weight - o.weight;
        }
    }

    public HashMap<Character, Integer> dijkstraAllShortestPath(HashMap<Character, HashMap<Character, Integer>> graph, char s) {
        PriorityQueue<HeapNode> pq = new PriorityQueue<HeapNode>();
        HashMap<Character, Integer> result = new HashMap<Character, Integer>();
        HashMap<Character, Integer> tx = new HashMap<Character, Integer>();
        tx.put(s, 0);
        pq.add(new HeapNode(0, s));
 
        while (!pq.isEmpty()) {
            HeapNode c = pq.poll();
            char v = c.tail;
            int w = c.weight;

            /*
             * Jump over deprecated values in X'
             * 
             */
            if (result.containsKey(v) || w > tx.get(v)) {
                continue;
            }

            result.put(v, w);

            for (Entry<Character, Integer> ent : graph.get(v).entrySet()) {
                char neighbor = ent.getKey();
                int nw = result.get(v) + graph.get(v).get(neighbor);

                if (!result.containsKey(neighbor) && (!tx.containsKey(neighbor) || nw < tx.get(neighbor))) {
                    tx.put(neighbor, nw);
                    pq.add(new HeapNode(nw, neighbor));
                }
            }
        }

        return result;
    }
}
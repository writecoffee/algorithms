import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Implement Kruskal's algorithm for generating minimum spanning tree as follows:
 * 
 *    sort edges in increasing order
 *    [rename edge 1,2,3,...m, so that c1 < c2 < c3 < ... < cm] 
 *    T = empty set
 *    for i = 1 to m
 *        if T U {i} has no cycle
 *            add i to T
 *            return T
 * 
 * [Difficulty] - Medium
 * [Source]     - Classical problem
 *
 */
public class uf_minimum_spanning_tree {
    public class Edge implements Comparable<Edge> {
        private final String u, v;
        private final int cost;

        public Edge(String _u, String _v, int _cost) {
            u = _u;
            v = _v;
            cost = _cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    public ArrayList<Edge> findMinSpanning(Edge[] edges, HashMap<String, ArrayList<String>> hUnderling, HashMap<String, String> hLeader) {
        ArrayList<Edge> result = new ArrayList<Edge>();
        Arrays.sort(edges);

        for (Edge e : edges) {
            String u = e.u, v = e.v;

            if (hUnderling.size() == 1) {
                break;
            } else if (hLeader.get(u).equals(hLeader.get(v))) {
                continue;
            }
 
            String uLead = hLeader.get(u), vLead = hLeader.get(v);

            if (hUnderling.get(vLead).size() > hUnderling.get(uLead).size()) {
                String t = v;
                v = u;
                u = t;
                t = vLead;
                vLead = uLead;
                uLead = t;
            }

            for (String underling : hUnderling.get(v)) {
                hLeader.put(underling, uLead);
            }

            hUnderling.get(uLead).addAll(hUnderling.get(vLead));
            hUnderling.remove(vLead);
            result.add(e);
        }

        return result;
    }
}
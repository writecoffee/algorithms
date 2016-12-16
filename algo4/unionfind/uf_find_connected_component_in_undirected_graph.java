import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the number connected component in the undirected graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * (a connected component (or just component) of an undirected graph is
 * a subgraph in which any two vertices are connected to each other by
 * paths, and which is connected to no additional vertices in the
 * supergraph.)
 *
 * Have you met this question in a real interview? Yes
 * Clarification
 * Learn more about representation of graphs
 *
 * Example
 * Given graph:
 *
 * A------B  C
 *  \     |  |
 *   \    |  |
 *    \   |  |
 *     \  |  |
 *       D   E
 *
 * Return {A,B,D}, {C,E}. Since there are two connected component which is {A,B,D}, {C,E}
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/find-the-connected-component-in-the-undirected-graph/}
 * [Difficulty] - Medium
 *
 */
public class uf_find_connected_component_in_undirected_graph
{
    class UndirectedGraphNode
    {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };

    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes)
    {
        Map<Integer, Integer> leaders = new HashMap<>();

        for (UndirectedGraphNode node : nodes) {
            int uLeader = safeGetLeader(node.label, leaders);

            for (UndirectedGraphNode neighbor : node.neighbors) {
                int vLeader = safeGetLeader(neighbor.label, leaders);

                leaders.put(vLeader, uLeader);
            }
        }

        Map<Integer, List<Integer>> clusters = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : leaders.entrySet()) {
            int nodeLabel = entry.getKey();
            int nodeLeader = safeGetLeader(nodeLabel, leaders);

            List<Integer> cluster = clusters.get(nodeLeader);
            if (cluster == null) {
                cluster = new ArrayList<>();
                clusters.put(nodeLeader, cluster);
            }

            cluster.add(nodeLabel);
        }

        for (List<Integer> l : clusters.values()) {
            Collections.sort(l);
        }

        return new ArrayList<List<Integer>>(clusters.values());
    }

    private int safeGetLeader(int label, Map<Integer, Integer> leaders)
    {
        if (!leaders.containsKey(label)) {
            leaders.put(label, label);
        }

        int i = label;
        while (leaders.get(label) != label) {
            label = leaders.get(label);
        }

        while (leaders.get(i) != i) {
            int next = leaders.get(i);
            leaders.put(i, label);
            i = next;
        }

        return label;
    }
}

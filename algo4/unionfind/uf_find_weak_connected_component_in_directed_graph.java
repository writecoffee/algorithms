import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Find the number Weak Connected Component in the directed graph.
 * Each node in the graph contains a label and a list of its neighbors.
 * (a connected set of a directed graph is a subgraph in which any two
 * vertices are connected by direct edge path.)
 *
 * Example
 *
 * Given graph:
 *
 * A----->B  C
 *  \     |  |
 *   \    |  |
 *    \   |  |
 *     \  v  v
 *      ->D  E <- F
 *
 * Return {A,B,D}, {C,E,F}. Since there are two connected component which
 * are {A,B,D} and {C,E,F}
 *
 * Note
 *
 * Sort the element in the set in increasing order.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/#}
 * [Tag]        - $graph$
 *
 */
public class uf_find_weak_connected_component_in_directed_graph
{
    class DirectedGraphNode
    {
        int                          label;
        ArrayList<DirectedGraphNode> neighbors;

        DirectedGraphNode(int x)
        {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    };

    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes)
    {
        Map<Integer, Integer> leaders = new HashMap<>();

        for (DirectedGraphNode node : nodes) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                int leadA = safeFind(leaders, node.label),
                    leadB = safeFind(leaders, neighbor.label);

                leaders.put(leadA, leadB);
            }
        }

        Map<Integer, List<Integer>> records = new HashMap<>();

        for (DirectedGraphNode node : nodes) {
            int leader = safeFind(leaders, node.label);
            safeUnion(records, leader, node.label);
        }

        return new ArrayList<>(records.values());
    }

    private void safeUnion(Map<Integer, List<Integer>> records, int parent, int node)
    {
        if (!records.containsKey(parent)) {
            records.put(parent, new ArrayList<>());
        }

        records.get(parent).add(node);
    }

    private int safeFind(Map<Integer, Integer> leaders, int node)
    {
        if (!leaders.containsKey(node)) {
            leaders.put(node, node);
        }

        int result = node;
        while (leaders.get(result) != result) {
            result = leaders.get(result);
        }

        while (node != leaders.get(node)) {
            int t = leaders.get(node);
            leaders.put(node, result);
            node = t;
        }

        return result;
    }
}

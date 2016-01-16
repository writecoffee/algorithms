import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 *
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 *
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * Visually, the graph looks like the following:
 *
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 *
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/clone-graph/}
 *
 */
public class gr_clone_graph
{
    private class UndirectedGraphNode
    {
        private int                            label;
        private ArrayList<UndirectedGraphNode> neighbors;

        private UndirectedGraphNode(int x)
        {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        if (node == null) {
            return null;
        }

        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<Integer, UndirectedGraphNode> h = new HashMap<Integer, UndirectedGraphNode>();
        q.add(node);
        h.put(node.label, new UndirectedGraphNode(node.label));

        while (!q.isEmpty()) {
            UndirectedGraphNode c1 = q.poll();
            UndirectedGraphNode c2 = h.get(c1.label);

            for (UndirectedGraphNode u : c1.neighbors) {
                if (!h.containsKey(u.label)) {
                    UndirectedGraphNode uCloned = new UndirectedGraphNode(u.label);
                    c2.neighbors.add(uCloned);
                    h.put(u.label, uCloned);
                    q.add(u);
                } else {
                    c2.neighbors.add(h.get(u.label));
                }
            }
        }

        return h.get(node.label);
    }

    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node)
    {
        if (node == null) {
            return null;
        }

        HashMap<Integer, UndirectedGraphNode> h = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode nodeCloned = new UndirectedGraphNode(node.label);
        h.put(node.label, nodeCloned);
        explore(node, nodeCloned, h);
        return nodeCloned;
    }

    private void explore(UndirectedGraphNode c1, UndirectedGraphNode c2, HashMap<Integer, UndirectedGraphNode> h)
    {
        for (UndirectedGraphNode n : c1.neighbors) {
            if (!h.containsKey(n.label)) {
                UndirectedGraphNode nCloned = new UndirectedGraphNode(n.label);
                h.put(n.label, nCloned);
                c2.neighbors.add(nCloned);
                explore(n, nCloned, h);
            } else {
                c2.neighbors.add(h.get(n.label));
            }
        }
    }
}

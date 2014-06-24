import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/clone-graph/}
 *
 */
public class gr_clone_graph {
    private class UndirectedGraphNode {
        private int label;
        private ArrayList<UndirectedGraphNode> neighbors;

        private UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
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

    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, UndirectedGraphNode> h = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode nodeCloned = new UndirectedGraphNode(node.label);
        h.put(node.label, nodeCloned);
        explore(node, nodeCloned, h);
        return nodeCloned;
    }

    private void explore(UndirectedGraphNode c1, UndirectedGraphNode c2, HashMap<Integer, UndirectedGraphNode> h) {
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
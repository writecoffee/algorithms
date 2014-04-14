import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class clone_graph {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
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
            UndirectedGraphNode v = q.poll();
            UndirectedGraphNode vCloned = h.get(v.label);

            for (UndirectedGraphNode u : v.neighbors) {
                if (!h.containsKey(u.label)) {
                    UndirectedGraphNode uCloned = new UndirectedGraphNode(u.label);
                    vCloned.neighbors.add(uCloned);
                    h.put(u.label, uCloned);
                    q.add(u);
                } else {
                    vCloned.neighbors.add(h.get(u.label));
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

    private void explore(UndirectedGraphNode c, UndirectedGraphNode cCloned, HashMap<Integer, UndirectedGraphNode> h) {
        for (UndirectedGraphNode n : c.neighbors) {
            if (!h.containsKey(n.label)) {
                UndirectedGraphNode nCloned = new UndirectedGraphNode(n.label);
                h.put(n.label, nCloned);
                cCloned.neighbors.add(nCloned);
                explore(n, nCloned, h);
            } else {
                cCloned.neighbors.add(h.get(n.label));
            }
        }
    }
}
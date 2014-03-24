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
        Queue<UndirectedGraphNode> p;
        HashMap<Integer, UndirectedGraphNode> visited = new HashMap<Integer, UndirectedGraphNode>();
        q.add(node);
        visited.put(node.label, new UndirectedGraphNode(node.label));

        while (!q.isEmpty()) {
            p = new LinkedList<UndirectedGraphNode>(q);
            q.clear();

            while (!p.isEmpty()) {
                UndirectedGraphNode v = p.poll();
                UndirectedGraphNode vCloned = visited.get(v.label);

                for (UndirectedGraphNode u : v.neighbors) {
                    if (!visited.containsKey(u.label)) {
                        UndirectedGraphNode uCloned = new UndirectedGraphNode(u.label);
                        vCloned.neighbors.add(uCloned);
                        visited.put(u.label, uCloned);
                        q.add(u);
                    } else {
                        vCloned.neighbors.add(visited.get(u.label));
                    }
                }
            }
        }

        return visited.get(node.label);
    }
}
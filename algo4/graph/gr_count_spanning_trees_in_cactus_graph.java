import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Count how many spanning tree in a cactus graph.
 * 
 * Cactus graph is like this:
 * 
 *                   3
 *                 /   \
 *          1 --- 2     4
 *                 \   /
 *                   5
 *                 /   \
 *                6 --- 7
 * 
 * [Difficulty] - Hard
 * [Source]     - imo.im interview
 * 
 */
public class gr_count_spanning_trees_in_cactus_graph {
    class GraphNode {
        public ArrayList<GraphNode> neighbors;
        public final int label;

        public GraphNode(int _label) {
            neighbors = new ArrayList<GraphNode>();
            label = _label;
        }

        public void addNeighbor(GraphNode n) {
            neighbors.add(n);
        }
    }

    class Link {
        public final GraphNode u;
        public final GraphNode v;

        Link(GraphNode _u, GraphNode _v) {
            assert _u.label < _v.label;
            u = _u;
            v = _v;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(u.label).append(v.label).toHashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other instanceof Link) {
                Link l = (Link) other;
                return new EqualsBuilder().append(u.label, l.u.label).append(v.label, l.v.label).isEquals();
            } else {
                return false;
            }
        }
    }

    public int countSpanningTrees(ArrayList<GraphNode> nodes) {
        HashMap<GraphNode, GraphNode> visited = new HashMap<GraphNode, GraphNode>();
        visited.put(nodes.get(0), null);
        return explore(nodes, nodes.get(0), visited, new HashSet<Link>());
    }

    private int explore(ArrayList<GraphNode> nodes, GraphNode c, HashMap<GraphNode, GraphNode> hPredec, HashSet<Link> circleLinks) {
        int result = 1;
        GraphNode predec = hPredec.get(c);

        for (GraphNode neighbor : c.neighbors) {
            if (neighbor == predec || circleLinks.contains(peekLink(c, neighbor))) {
                continue;
            } else if (hPredec.containsKey(neighbor)) {
                ArrayList<Link> circle = backtrack(c, neighbor, hPredec);
                circleLinks.addAll(circle);
                result *= circle.size();
            } else {
                hPredec.put(neighbor, c);
                result *= explore(nodes, neighbor, hPredec, circleLinks);
            }
        }

        return result;
    }

    private ArrayList<Link> backtrack(GraphNode start, GraphNode end, HashMap<GraphNode, GraphNode> hPredec) {
        ArrayList<Link> circle = new ArrayList<Link>();
        GraphNode nxt = hPredec.get(start);
        GraphNode c = start;

        while (end != c) {
            circle.add(peekLink(c, nxt));
            c = nxt;
            nxt = hPredec.get(nxt);
        }
        circle.add(peekLink(c, start));

        return circle;
    }

    private Link peekLink(GraphNode u, GraphNode v) {
        if (u.label < v.label) {
            return new Link(u, v);
        } else {
            return new Link(v, u);
        }
    }
}
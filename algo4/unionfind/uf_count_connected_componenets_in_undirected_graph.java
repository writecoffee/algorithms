import java.util.HashSet;
import java.util.Set;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a
 * pair of nodes), write a function to find the number of connected components in an
 * undirected graph.
 * 
 * Example 1:
 * 
 *      0          3
 *      |          |
 *      1 --- 2    4
 *      
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 * 
 * Example 2:
 * 
 *      0           4
 *      |           |
 *      1 --- 2 --- 3
 *      
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * 
 * Note:
 * 
 * You can assume that no duplicate edges will appear in edges. Since all edges are
 * undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * 
 * [Source]     - {@linkplain https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/}
 * [Difficulty] - Medium
 * 
 */
public class uf_count_connected_componenets_in_undirected_graph
{
    public int countComponents(int n, int[][] edges)
    {
        int[] leaders = new int[n];
        for (int i = 0; i < n; i++) {
            leaders[i] = -1;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            int ul = find(u, leaders);
            int vl = find(v, leaders);

            leaders[vl] = ul;
        }

        Set<Integer> comp = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int leader = find(i, leaders);
            comp.add(leader);
        }

        return comp.size();
    }

    private int find(int v, int[] leaders)
    {
        if (leaders[v] == -1) {
            leaders[v] = v;
            return v;
        }

        int t = v;
        while (v != leaders[v]) {
            v = leaders[v];
        }

        while (t != leaders[t]) {
            int next = leaders[t];
            leaders[t] = v;
            t = next;
        }

        return v;
    }
}

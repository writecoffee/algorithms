/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each
 * edge is a pair of nodes), write a function to check whether these edges make
 * up a valid tree.
 *
 * For example:
 *
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return
 * false.
 *
 * Hint:
 *
 * 1. Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return?
 *    Is this case a valid tree?
 *
 * 2. According to the definition of tree on Wikipedia: “a tree is an undirected
 *    graph in which any two vertices are connected by exactly one path. In other
 *    words, any connected graph without simple cycles is a tree.”
 *
 * Note: you can assume that no duplicate edges will appear in edges. Since all
 * edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear
 * together in edges.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/graph-valid-tree/}
 *
 */
public class gr_graph_valid_tree
{
    public boolean validTree(int n, int[][] edges)
    {
        if (edges == null || edges.length != n - 1) {
            return false;
        }

        int[] union = new int[n];

        for (int i = 0; i < n; i++) {
            union[i] = i;
        }

        /*
         * Ensure smaller point points to larger point.
         * This can prevent union PARENT being overwritten.
         *
         */
        for (int[] edge : edges) {
            if (edge[0] > edge[1]) {
                int t = edge[0];
                edge[0] = edge[1];
                edge[1] = t;
            }
        }

        for (int[] edge : edges) {
            int p = edge[0], v = edge[1];

            if (findRoot(union, p) == findRoot(union, v)) {
                return false;
            }

            union[v] = p;
        }

        return true;
    }

    private int findRoot(int[] unionFind, int i)
    {
        while (i != unionFind[i]) {
            i = unionFind[i];
        }

        return i;
    }
}

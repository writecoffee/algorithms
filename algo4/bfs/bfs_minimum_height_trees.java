package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * For a undirected graph with tree characteristics, we can choose any node as the root.
 * The result graph is then a rooted tree. Among all possible rooted trees, those with
 * minimum height are called minimum height trees (MHTs). Given such a graph, write a
 * function to find all the MHTs and return a list of their root labels.
 *
 * Format
 *
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the
 * number n and a list of undirected edges (each edge is a pair of labels).
 *
 * You can assume that no duplicate edges will appear in edges. Since all edges are
 * undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 *
 * Example 1:
 *
 * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 *
 *         0
 *         |
 *         1
 *        / \
 *       2   3
 * return [1]
 *
 * Example 2:
 *
 * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 *
 *      0  1  2
 *       \ | /
 *         3
 *         |
 *         4
 *         |
 *         5
 *
 * return [3, 4]
 *
 * Hint:
 *
 * How many MHTs can a graph have at most?
 *
 * Note:
 *
 * (1) According to the definition of tree on Wikipedia: “a tree is an undirected graph
 *     in which any two vertices are connected by exactly one path. In other words, any
 *     connected graph without simple cycles is a tree.”
 *
 * (2) The height of a rooted tree is the number of edges on the longest downward path
 *     between the root and a leaf.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/minimum-height-trees/}
 *
 */
public class bfs_minimum_height_trees
{
    public List<Integer> findMinHeightTrees(int n, int[][] edges)
    {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        List<Integer> result = new ArrayList<Integer>();

        if (n == 1) {
            result.add(0);
            return result;
        }

        int[] degrees = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            degrees[edges[i][0]]++;
            degrees[edges[i][1]]++;
        }

        Queue<Integer> q = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (degrees[i] == 0) {
                return result;
            } else if (degrees[i] == 1) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            result = new ArrayList<>();
            Queue<Integer> p = new LinkedList<>(q);
            q.clear();

            while (!p.isEmpty()) {
                int c = p.poll();
                result.add(c);
                degrees[c]--;

                for (int next : graph.get(c)) {
                    if (degrees[next] == 0) {
                        continue;
                    }

                    degrees[next]--;

                    if (degrees[next] == 1) {
                        q.offer(next);
                    }
                }
            }
        }

        return result;
    }
}

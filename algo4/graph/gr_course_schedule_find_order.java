import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 *
 * For example:
 *
 * 2, [[1,0]]
 *
 * There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0. So the correct course order is [0,1]
 *
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 *
 * There are a total of 4 courses to take. To take course 3 you should have
 * finished both courses 1 and 2. Both courses 1 and 2 should be taken after you
 * finished course 0. So one correct course order is [0,1,2,3]. Another correct
 * ordering is[0,2,1,3].
 *
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/course-schedule-ii/}
 * [Tag]        - $dfs$, $bfs$, $topology sort$, $graph$
 *
 */
public class gr_course_schedule_find_order
{
    public static class BFSSolution
    {
        public int[] findOrder(int n, int[][] prerequisites)
        {
            ArrayList<ArrayList<Integer>> dependent = new ArrayList<ArrayList<Integer>>();
            int[] degrees = new int[n];
            int[] orders = new int[n];
            int last = 0;

            for (int i = 0; i < n; ++i) {
                dependent.add(new ArrayList<Integer>());
            }

            for (int[] edge : prerequisites) {
                dependent.get(edge[1]).add(edge[0]);
                degrees[edge[0]]++;
            }

            Queue<Integer> toBeFinished = new LinkedList<Integer>();
            for (int i = 0; i < n; ++i) {
                if (degrees[i] == 0) {
                    toBeFinished.add(i);
                }
            }

            while (!toBeFinished.isEmpty()) {
                int c = toBeFinished.poll();
                orders[last++] = c;

                for (Integer dep : dependent.get(c)) {
                    degrees[dep]--;
                    if (degrees[dep] == 0) {
                        toBeFinished.add(dep);
                    }
                }
            }

            if (last != n) {
                return new int[] {};
            } else {
                return orders;
            }
        }
    }

    public static class DFSSolution
    {
        public int[] findOrder(int n, int[][] prerequisites)
        {
            ArrayList<ArrayList<Integer>> dependencies = new ArrayList<ArrayList<Integer>>();
            int[] orders = new int[n];

            for (int i = 0; i < n; ++i) {
                dependencies.add(new ArrayList<Integer>());
            }

            for (int[] edge : prerequisites) {
                dependencies.get(edge[0]).add(edge[1]);
            }

            Set<Integer> done = new HashSet<Integer>();

try_all:
            for (int i = 0; i < n; ++i) {
                if (!done.contains(i) && !dfs(i, dependencies, new HashSet<Integer>(), done, orders)) {
                    break try_all;
                }
            }

            if (done.size() != n) {
                return new int[] {};
            } else {
                return orders;
            }
        }

        int last = 0;

        private boolean dfs(int c, ArrayList<ArrayList<Integer>> dependencies, Set<Integer> visited, Set<Integer> done, int[] orders)
        {
            if (visited.contains(c)) {
                return false;
            }

            visited.add(c);
            for (int next : dependencies.get(c)) {
                if (!done.contains(next)) {
                    if (!dfs(next, dependencies, visited, done, orders)) {
                        return false;
                    }
                }
            }
            visited.remove(c);
            done.add(c);

            orders[last++] = c;
            return true;
        }
    }
}

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 *
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 *
 * For example:
 *
 * 2, [[1,0]]
 *
 * There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So it is possible.
 *
 * 2, [[1,0],[0,1]]
 *
 * There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0, and to take course 0 you should also have
 * finished course 1. So it is impossible.
 *
 * Note: The input prerequisites is a graph represented by a list of edges, not
 * adjacency matrices. Read more about how a graph is represented.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/course-schedule/}
 *
 */
public class gr_course_schedule_possible
{
    public static class DFSSolution
    {
        public boolean canFinish(int n, int[][] prerequisite)
        {
            Set<Integer> visited = new HashSet<Integer>();

            for (int i = 0; i < prerequisite.length; ++i) {
                if (isLoop(visited, i, prerequisite.length, prerequisite)) {
                    return false;
                }
            }

            return true;
        }

        private boolean isLoop(Set<Integer> visited, int i, int n, int[][] p)
        {
            if (visited.contains(p[i][0])) {
                return true;
            }

            visited.add(p[i][0]);

            for (int j = 0; j < n; ++j) {
                if (j == i) {
                    continue;
                } else if (p[j][0] == p[i][1] && isLoop(visited, j, n, p)) {
                    return true;
                }
            }

            visited.remove(p[i][0]);
            return false;
        }
    }

    public static class DFSSolutionWithPreprocessing
    {
        public boolean canFinish(int n, int[][] prerequisite)
        {
            List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i < n; ++i) {
                graph.add(new ArrayList<>());
            }

            for (int[] edge : prerequisite) {
                graph.get(edge[1]).add(edge[0]);
            }

            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; ++i) {
                if (isLoop(visited, i, graph)) {
                    return false;
                }
            }

            return true;
        }

        private boolean isLoop(boolean[] visited, int i, List<ArrayList<Integer>> graph)
        {
            if (visited[i]) {
                return true;
            }

            visited[i] = true;
            for (int p : graph.get(i)) {
                if (isLoop(visited, p, graph)) {
                    return true;
                }
            }

            visited[i] = false;
            return false;
        }
    }

    public static class BFSSolution
    {
        public boolean canFinish(int n, int[][] prerequisite)
        {
            int[] degrees = new int[n];
            int finished = 0;

            for (int[] edge : prerequisite) {
                degrees[edge[0]]++;
            }

            List<ArrayList<Integer>> backtrack = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i < n; ++i) {
                backtrack.add(new ArrayList<>());
            }
            for (int[] edge : prerequisite) {
                backtrack.get(edge[1]).add(edge[0]);
            }

            Queue<Integer> toBeFinished = new LinkedList<Integer>();
            for (int i = 0; i < n; ++i) {
                if (degrees[i] == 0) {
                    toBeFinished.add(i);
                    finished++;
                }
            }

            while (!toBeFinished.isEmpty()) {
                int c = toBeFinished.poll();

                for (int dependence : backtrack.get(c)) {
                    degrees[dependence]--;

                    if (degrees[dependence] == 0) {
                        toBeFinished.add(dependence);
                        finished++;
                    }
                }
            }

            /*
             * How can you detect loop? If there is a loop there, all nodes in the loop
             * will never be added in [toBeFinished] and hence we can believe that they
             * won't finish.
             */
            return finished == n;
        }
    }
}

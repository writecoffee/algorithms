import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * There are n tasks need to be done (labeled from 1 to n). There are dependency relationship
 * between some of these tasks. If there is a possible topology output for these tasks, output
 * it to the result; otherwise, return false.
 * 
 * For example:
 * 
 * n = 5
 * 1->2,3
 * 3->4
 * 
 * One possible result would be 4, 3, 2, 1, 5.
 * 
 */
public class job_scheduling_with_dfs {
    /**
     * Given directed acyclic graph, order vertices so that all edges point from
     * lower order to higher order.
     * 
     * Topology sort:
     * 
     * Run DFS to output reverse of finishing time of vertices.
     *
     */
    public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n, int[] result) {
        if (detectCycle(deps, n)) {
            return false;
        }

        HashSet<Integer> visited = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < n; ++i) {
            count += explore(i + 1, deps, visited, count, result);
        }

        return count == n;
    }

    private boolean detectCycle(Map<Integer, List<Integer>> deps, int n) {
        HashSet<Integer> visited = new HashSet<Integer>();

        for (int i = 0; i < n; ++i) {
            visited.add(i + 1);
            if (detect(i + 1, deps, visited)) {
                return true;
            }
            visited.remove(i + 1);
        }

        return false;
    }

    private boolean detect(int id, Map<Integer, List<Integer>> deps, HashSet<Integer> visited) {
        if (!deps.containsKey(id)) {
            return false;
        }

        for (int parent : deps.get(id)) {
            if (visited.contains(parent)) {
                return true;
            }

            visited.add(parent);
            if (detect(parent, deps, visited)) {
                return true;
            }
            visited.remove(parent);
        }

        return false;
    }

    private int explore(int id, Map<Integer, List<Integer>> hDeps, HashSet<Integer> visited, int start, int[] result) {
        if (visited.contains(id)) {
            return 0;
        } else if (!hDeps.containsKey(id)) {
            visited.add(id);
            result[start] = id;
            return 1;
        }

        int count = 0;

        for (int child : hDeps.get(id)) {
            count += explore(child, hDeps, visited, start + count, result);
        }

        visited.add(id);
        result[start + count] = id;
        return count + 1;
    }
}
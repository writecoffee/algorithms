import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that
 * has the smallest lexical order when read as a single string. For example, the
 * itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"]. All
 * airports are represented by three capital letters (IATA code).
 *
 * You may assume all tickets form at least one valid itinerary.
 *
 * Example 1:
 *
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 *
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 *
 * Example 2:
 *
 * tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 *
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
 *
 * Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But
 * it is larger in lexical order.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/reconstruct-itinerary/}
 *
 */
public class dfs_reconstruct_itinerary
{
    public List<String> findItinerary(String[][] tickets)
    {
        /*
         * Construct adjacency list.
         */
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        ArrayList<String> h = null;

        for (String[] ticket : tickets) {
            h = graph.get(ticket[0]);

            if (h == null) {
                h = new ArrayList<String>();
                graph.put(ticket[0], h);
            }

            h.add(ticket[1]);
        }

        for (ArrayList<String> curr : graph.values()) {
            Collections.sort(curr);
        }

        ArrayList<String> result = new ArrayList<>();
        explore("JFK", result, graph, tickets.length + 1);
        return result;
    }

    public boolean explore(String depart, List<String> result, HashMap<String, ArrayList<String>> graph, int n)
    {
        result.add(depart);
        if (result.size() >= n) {
            return true;
        }

        if (!graph.containsKey(depart) || graph.get(depart).isEmpty()) {
            result.remove(result.size() - 1);
            return false;
        }

        ArrayList<String> arrivals = graph.get(depart);
        for (int i = 0; i < arrivals.size(); i++) {
            String nextHop = arrivals.remove(i);

            if (explore(nextHop, result, graph, n)) {
                return true;
            }

            arrivals.add(i, nextHop);
        }

        result.remove(result.size() - 1);
        return false;
    }
}

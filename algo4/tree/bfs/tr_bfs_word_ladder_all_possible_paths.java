package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class tr_bfs_word_ladder_all_possible_paths {
    /**
     * This becomes a graph problem:
     * 
     *             red
     *           /     \
     *       ted        rex
     *     /     \     /
     *   tad       tex
     *     \     /
     *       tax
     */
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        HashMap<String, HashSet<String>> hParents = new HashMap<String, HashSet<String>>();
        HashMap<String, Integer> hLevel = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();

        hParents.put(start, new HashSet<String>());
        hLevel.put(start, 1);
        q.add(start);

        while (!q.isEmpty()) {
            String c = q.poll();

            if (c.equals(end)) {
                backtrack(c, hParents, new ArrayDeque<String>(), result);
                break;
            }

            for (int i = 0; i < c.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    char[] cStr = c.toCharArray();
                    cStr[i] = j;
                    String ts = new String(cStr);

                    if (dict.contains(ts) && !hLevel.containsKey(ts)) {
                        HashSet<String> parents = new HashSet<String>();
                        parents.add(c);
                        hParents.put(ts, parents);
                        hLevel.put(ts, hLevel.get(c) + 1);
                        q.add(ts);
                    } else if (dict.contains(ts) && hLevel.containsKey(ts) && hLevel.get(ts) == hLevel.get(c) + 1) {
                        hParents.get(ts).add(c);
                    }
                }
            }
        }

        return result;
    }

    private void backtrack(String c, HashMap<String, HashSet<String>> parents, Deque<String> pre, ArrayList<ArrayList<String>> result) {
        Deque<String> nxt = new ArrayDeque<String>(pre);
        nxt.addFirst(c);

        if (parents.get(c).isEmpty()) {
            result.add(new ArrayList<String>(nxt));
            return;
        }

        for (String parent : parents.get(c)) {
            backtrack(parent, parents, nxt, result);
        }
    }
}
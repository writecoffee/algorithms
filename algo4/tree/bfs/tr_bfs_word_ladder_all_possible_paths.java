package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 * 
 *     1. Only one letter can be changed at a time
 *     2. Each intermediate word must exist in the dictionary
 * 
 * For example,
 * 
 *     Given:
 * 
 *     start = "hit"
 *     end   = "cog"
 *     dict  = ["hot","dot","dog","lot","log"]
 * 
 *     Return
 * 
 *       [
 *         ["hit","hot","dot","dog","cog"],
 *         ["hit","hot","lot","log","cog"]
 *       ]
 * 
 * Note:
 * 
 *     -- All words have the same length.
 *     -- All words contain only lowercase alphabetic characters.
 * 
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/word-ladder-ii/}
 * 
 */
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
     * 
     * where a node in the graph can be connected more than once from nodes in its previous level.
     * 
     * As a follow-up question from word-ladder-i, the time complexity and space complexity both
     * increase as the number of links in the graph grow.
     * 
     */
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        HashMap<String, ArrayList<String>> hParents = new HashMap<String, ArrayList<String>>();
        HashMap<String, Integer> hLevels = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        hLevels.put(start, 1);
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        while (!q.isEmpty()) {
            String c = q.poll();

            if (c.equals(end)) {
                backtrack(start, end, hParents, new ArrayDeque<String>(), result);
                break;
            }

            for (int i = 0; i < start.length(); ++i) {
                for (char j = 'a'; j <= 'z'; ++j) {
                    char[] cstr = c.toCharArray();
                    cstr[i] = j;
                    String t = new String(cstr);

                    if (dict.contains(t) && !hLevels.containsKey(t)) {
                        hParents.put(t, new ArrayList<String>());
                        hParents.get(t).add(c);
                        hLevels.put(t, hLevels.get(c) + 1);
                        q.add(t);
                    } else if (dict.contains(t) && hLevels.get(t) == hLevels.get(c) + 1) {
                        hParents.get(t).add(c);
                    }
                }
            }
        }

        return result;
    }

    private void backtrack(String start, String c, HashMap<String, ArrayList<String>> hParents, ArrayDeque<String> path, ArrayList<ArrayList<String>> result) {
        path.addFirst(c);

        if (c.equals(start)) {
            result.add(new ArrayList<String>(path));
        } else {
            for (String parent : hParents.get(c)) {
                backtrack(start, parent, hParents, path, result);
            }
        }

        path.removeFirst();

    }
}
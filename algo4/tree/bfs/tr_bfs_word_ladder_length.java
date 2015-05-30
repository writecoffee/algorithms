package bfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest
 * transformation sequence from start to end, such that:
 *
 *     1. Only one letter can be changed at a time
 *     2. Each intermediate word must exist in the dictionary
 * 
 * For example,
 *
 *     Given:
 * 
 *     start = "hit"
 *     end = "cog"
 *     dict = ["hot","dot","dog","lot","log"]
 * 
 *     As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *     return its length 5.
 *
 * Note:
 * 
 *     -- Return 0 if there is no such transformation sequence.
 *     -- All words have the same length.
 *     -- All words contain only lower-case alphabetic characters.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/word-ladder/} 
 *
 */
public class tr_bfs_word_ladder_length {
    /**
     * -- Solution
     * 
     *    Using breath-first-search to probe the minimum distance is an optimal
     *    solution; otherwise using depth-first-search would require exploring
     *    every "node" and compute the minimum.
     * 
     * -- Time Complexity
     * 
     *    In terms of time complexity, there are n number of words in the dictionary
     *    and hence there are at most n nodes in the graph. We are going to modify
     *    each valid word m times to probe its potential neighbor, where m is the word
     *    length. So the total time complexity is O(n * m).
     * 
     * -- Comparison with DFS
     * 
     *    Can we use depth-first-search? This would not be a sufficient solution.
     *    There could be more than one possible transformation sequence and we have
     *    to keep track of their length and calculate the minimum path length over
     *    all possible transformation.
     * 
     *    Although we skip visited nodes, in worst cases, it may end up with touching
     *    every word once for one DFS route. And for each word, to find out which word
     *    is a neighbor, we need to check every other word on the count of different
     *    letters, which takes O(n * m) time. So the total running time for this solution
     *    is O(n * n * m).
     * 
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        h.put(start, 1);

        while (!q.isEmpty()) {
            String u = q.poll();
            int height = h.get(u);

            if (u.equals(end)) {
                return height;
            }

            for (int i = 0; i < u.length(); ++i) {
                for (char j = 'a'; j <= 'z'; ++j) {
                    char[] cStr = u.toCharArray();
                    cStr[i] = j;
                    String t = new String(cStr);

                    if (!h.containsKey(t) && dict.contains(t)) {
                        q.add(t);
                        h.put(t, height + 1);
                    }
                }
            }
        }

        return 0;
    }

    /**
     * For this solution, we save half of the memory because we can use a level
     * traversal methodology to find the minimum distance between start and end.
     * 
     */
    public int ladderLengthOptimized(String start, String end, Set<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        q.add(null);
        int level = 1;
        HashSet<String> h = new HashSet<String>();
        h.add(start);

        while (true) {
            String c = q.poll();

            if (c == null && q.isEmpty()) {
                break;
            } else if (c == null) {
                level++;
                q.add(null);
                continue;
            } else if (c.equals(end)) {
                return level;
            }

            for (int i = 0; i < c.length(); ++i) {
                for (char j = 'a'; j <= 'z'; ++j) {
                    char[] cStr = c.toCharArray();
                    cStr[i] = j;
                    String t = new String(cStr);

                    if (!h.contains(t) && dict.contains(t)) {
                        q.add(t);
                        h.add(t);
                    }
                }
            }
        }

        return 0;
    }
}
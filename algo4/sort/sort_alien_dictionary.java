import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * There is a new alien language which uses the latin alphabet. However, the order among letters
 * are unknown to you. You receive a list of words from the dictionary, where words are sorted
 * lexicographically by the rules of this new language. Derive the order of letters in this
 * language.
 *
 * For example,
 *
 * Given the following words in dictionary,
 *
 * [
 *   "wrt",
 *   "wrf",
 *   "er",
 *   "ett",
 *   "rftt"
 * ]
 *
 * The correct order is: "wertf".
 *
 * Note:
 *
 * 1. You may assume all letters are in lowercase.
 *
 * 2. If the order is invalid, return an empty string.
 *
 * 3. There may be multiple valid order of letters, return any one of them is fine.
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/alien-dictionary/}
 *
 */
public class sort_alien_dictionary
{
    public String alienOrder(String[] words)
    {
        int n = words.length;

        int rounds = 0;
        for (String word : words) {
            rounds = Math.max(word.length(), rounds);
        }

        Map<Character, Integer> indegree = new HashMap<>();
        Map<Character, Set<Character>> happensBefore = new HashMap<>();

        constructGraph(n, rounds, words, indegree, happensBefore);

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();

        for (Map.Entry<Character, Integer> entry : indegree.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (value == 0) {
                q.add(key);
            }
        }

        while (!q.isEmpty()) {
            Queue<Character> tq = new LinkedList<>(q);
            q.clear();

            while (!tq.isEmpty()) {
                Character c = tq.poll();
                sb.append(c);

                for (char notified : happensBefore.get(c)) {
                    indegree.put(notified, indegree.get(notified) - 1);

                    if (indegree.get(notified) == 0) {
                        q.add(notified);
                    }
                }
            }
        }

        /*
         * Detect if any characters that are not finished.
         */
        for (int relies : indegree.values()) {
            if (relies != 0) {
                return "";
            }
        }

        return sb.toString();
    }

    private void constructGraph(int n, int rounds, String[] words, Map<Character, Integer> indegree, Map<Character, Set<Character>> happensBefore)
    {
        for (String s : words) {
            for (char c : s.toCharArray()) {
                safeAdd(c, indegree, happensBefore);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < rounds; j++) {
                if (!isSamePrefix(words[i], words[i - 1], j)) {
                    break;
                } else if (words[i].charAt(j) == words[i - 1].charAt(j)) {
                    continue;
                }

                char from = words[i - 1].charAt(j), to = words[i].charAt(j);

                happensBefore.get(from).add(to);
                indegree.put(to, indegree.get(to) + 1);
            }
        }
    }

    private void safeAdd(char c, Map<Character, Integer> indegrees, Map<Character, Set<Character>> notifier)
    {
        if (!indegrees.containsKey(c)) {
            indegrees.put(c, 0);
        }

        if (!notifier.containsKey(c)) {
            notifier.put(c, new HashSet<Character>());
        }
    }

    private boolean isSamePrefix(String a, String b, int endIndex)
    {
        if (endIndex >= a.length() || endIndex >= b.length()) {
            return false;
        } else if (endIndex == 0) {
            return true;
        }

        return a.charAt(endIndex - 1) == b.charAt(endIndex - 1);
    }
}

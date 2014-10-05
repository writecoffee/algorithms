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

        Map<Character, Set<Character>> relyOn = new HashMap<>();
        Map<Character, Set<Character>> notifier = new HashMap<>();

        for (int i = 0; i < rounds; i++) {
            addIfNotExists(words[0], i, relyOn, notifier);

            for (int j = 1; j < n; j++) {
                addIfNotExists(words[j], i, relyOn, notifier);

                if (isSamePrefix(words[j], words[j - 1], i)) {
                    char from = words[j].charAt(i),
                         to = words[j - 1].charAt(i);

                    notifier.get(to).add(from);
                    relyOn.get(from).add(to);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();

        for (Map.Entry<Character, Set<Character>> entry : relyOn.entrySet()) {
            char key = entry.getKey();
            Set<Character> value = entry.getValue();

            if (value.isEmpty()) {
                q.add(key);
            }
        }

        while (!q.isEmpty()) {
            Queue<Character> tq = new LinkedList<>(q);
            q.clear();

            while (!tq.isEmpty()) {
                Character c = tq.poll();
                sb.append(c);

                for (char notified : notifier.get(c)) {
                    relyOn.get(notified).remove(c);

                    if (relyOn.get(notified).isEmpty()) {
                        q.add(notified);
                    }
                }
            }
        }

        /*
         * Detect if any characters that are not finished.
         */
        for (Set<Character> relies : relyOn.values()) {
           if (!relies.isEmpty()) {
               return "";
           }
        }

        return sb.toString();
    }

    private void addIfNotExists(String string, int i, Map<Character, Set<Character>> relyOn, Map<Character, Set<Character>> notifier)
    {
        if (i >= string.length()) {
            return;
        }

        relyOn.putIfAbsent(string.charAt(i), new HashSet<>());
        notifier.putIfAbsent(string.charAt(i), new HashSet<>());
    }

    private boolean isSamePrefix(String a, String b, int endIndex)
    {
        if (endIndex >= a.length() || endIndex >= b.length()) {
            return false;
        }

        for (int i = 0; i < endIndex; i++) {
            char ac = a.charAt(i),
                 bc = b.charAt(i);

            if (ac != bc) {
                return false;
            }
        }

        return a.charAt(endIndex) != b.charAt(endIndex);
    }
}

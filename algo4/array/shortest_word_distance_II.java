import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you
 * are given the list of words and your method will be called repeatedly many
 * times with different parameters. How would you optimize it?
 *
 * Design a class which receives a list of words in the constructor, and
 * implements a method that takes two words word1 and word2 and return the
 * shortest distance between these two words in the list.
 *
 * For example,
 *
 * Assume that words = ["practice", "makes", "perfect", "coding",
 * "makes"].
 *
 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes",
 * word2 = "coding", return 1.
 *
 * Note:
 *
 * You may assume that word1 does not equal to word2, and word1 and word2 are
 * both in the list.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/shortest-word-distance-ii/}
 *
 */
public class shortest_word_distance_II
{
    public class WordDistanceTLE
    {
        Map<String, Map<String, Integer>> wordMap = new HashMap<>();

        public WordDistanceTLE(String[] words)
        {
            int n = words.length;

            HashSet<String> wordSet = new HashSet<>();
            for (String word : words) {
                wordSet.add(word);
            }

            for (String word : wordSet) {
                wordMap.put(word, new HashMap<String, Integer>());
            }

            List<String> wordList = new ArrayList<>(wordSet);
            n = wordList.size();
            for (int i = 0; i < n; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    String word1 = wordList.get(i), word2 = wordList.get(j);

                    if (!wordMap.get(word1).containsKey(word2)) {
                        wordMap.get(word1).put(word2, n);
                    }

                    if (!wordMap.get(word2).containsKey(word1)) {
                        wordMap.get(word2).put(word1, n);
                    }

                    wordMap.get(word1).put(word2, Math.min(i - j, wordMap.get(word1).get(word2)));
                    wordMap.get(word2).put(word1, Math.min(i - j, wordMap.get(word2).get(word1)));
                }
            }
        }

        public int shortest(String word1, String word2)
        {
            return wordMap.get(word1).get(word2);
        }
    }

    public class WordDistance
    {
        Map<String, List<Integer>> wordMap = new HashMap<>();

        public WordDistance(String[] words)
        {
            int n = words.length;

            for (int i = 0; i < n; i++) {
                String word = words[i];

                if (!wordMap.containsKey(word)) {
                    wordMap.put(word, new ArrayList<>());
                }

                wordMap.get(word).add(i);
            }
        }

        public int shortest(String word1, String word2)
        {
            List<Integer> w1 = wordMap.get(word1), w2 = wordMap.get(word2);

            int result = Integer.MAX_VALUE;
            for (int i = 0; i < w1.size(); i++) {
                for (int j = 0; j < w2.size(); j++) {
                    result = Math.min(result, Math.abs(w1.get(i) - w2.get(j)));
                }
            }

            return result;
        }
    }
}

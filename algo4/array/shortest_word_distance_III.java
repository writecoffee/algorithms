/**
 * This is a follow up of Shortest Word Distance. The only difference is now
 * word1 could be the same as word2.
 *
 * Given a list of words and two words word1 and word2, return the shortest
 * distance between these two words in the list.
 *
 * word1 and word2 may be the same and they represent two individual words in
 * the list.
 *
 * For example,
 *
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Given word1 = “makes”, word2 = “coding”, return 1.
 *
 * Given word1 = "makes", word2 = "makes", return 3.
 *
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/shortest-word-distance-ii/}
 *
 */
public class shortest_word_distance_III
{
    public int shortestWordDistance(String[] words, String word1, String word2)
    {
        int index1 = -1, index2 = -1, result = words.length;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (word.equals(word1)) {

                if (word1.equals(word2) && index1 != -1) {
                    index2 = index1;
                    index1 = i;
                } else {
                    index1 = i;
                }
            } else if (word.equals(word2)) {
                index2 = i;
            }

            if (index1 != -1 && index2 != -1) {
                result = Math.min(result, Math.abs(index1 - index2));
            }
        }

        return result;
    }
}

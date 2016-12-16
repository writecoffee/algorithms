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
        int n = words.length;
        int[] indices = new int[] { -1, -1 };
        int j = 0;
        int result = Integer.MAX_VALUE;
        boolean isSame = word1.equals(word2);

        for (int i = 0; i < n; i++) {
            String word = words[i];

            if (isSame && word.equals(word1)) {
                indices[j % 2] = i;
                j++;
            } else if (word.equals(word1)) {
                indices[0] = i;
                j++;
            } else if (word.equals(word2)) {
                indices[1] = i;
                j++;
            }

            if (j >= 2) {
                int i1 = (j - 1) % 2;
                int i2 = (j - 2) % 2;
                result = Math.min(result, Math.abs(indices[i1] - indices[i2]));
            }
        }

        return result;
    }
}

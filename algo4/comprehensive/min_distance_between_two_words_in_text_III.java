import java.util.ArrayList;
import java.util.HashMap;

/**
 * You have a large text file containing words. Given any two words, find the shortest distance (in
 * terms of number of words) between them in the file. If the operation will be repeated many times
 * for the same file (but different pairs of words), can you optimize your solution?
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain CC150-18.5}
 * 
 */
public class min_distance_between_two_words_in_text_III {
    private HashMap<String, ArrayList<Integer>> h = new HashMap<String, ArrayList<Integer>>();

    public int getMinDistance(String a, String b) {
        ArrayList<Integer> aPos = h.get(a);
        ArrayList<Integer> bPos = h.get(b);

        int i = 0, j = 0, m = aPos.size(), n = bPos.size();
        int gMin = Integer.MAX_VALUE;

        while (i < m && j < n) {
            gMin = Math.min(gMin, Math.abs(aPos.get(i) - bPos.get(j)));

            if (aPos.get(i) > bPos.get(j)) {
                j++;
            } else {
                i++;
            }
        }

        return gMin;
    }

    public void preprocessing(String[] words) {
        int n = words.length;

        for (int i = 0; i < n; ++i) {
            String word = words[i];

            if (!h.containsKey(word)) {
                h.put(word, new ArrayList<Integer>());
            }

            h.get(word).add(i);
        }
    }
}
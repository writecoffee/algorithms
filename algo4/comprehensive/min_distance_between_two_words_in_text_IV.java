import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * You have a large text file containing words. Given any two words, find the shortest distance (in
 * terms of number of words) between them in the file. If the operation will be repeated many times
 * for the same file (but different pairs of words), can you optimize your solution?
 * 
 * Now try to optimize the time complexity to be O(1).
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain CC150-18.5}
 * 
 */
public class min_distance_between_two_words_in_text_IV {
    private HashMap<String, Integer> hOpt = new HashMap<String, Integer>();

    public int getMinDistance(String a, String b) {
        String t = a.compareTo(b) < 0 ? a + "#" + b : b + "#" + a;

        if (!hOpt.containsKey(t)) {
            return -1;
        } else {
            return hOpt.get(t);
        }
    }

    public void preprocessing(String[] words) {
        HashMap<String, ArrayList<Integer>> h = new HashMap<String, ArrayList<Integer>>();
        int n = words.length;

        for (int i = 0; i < n; ++i) {
            String word = words[i];

            if (!h.containsKey(word)) {
                h.put(word, new ArrayList<Integer>());
            }

            h.get(word).add(i);
        }

        ArrayList<String> keySet = new ArrayList<String>(h.keySet());
        Collections.sort(keySet);

        for (int i = 0; i < keySet.size(); ++i) {
            String a = keySet.get(i);

            for (int j = i + 1; j < keySet.size(); ++j) {
                String b = keySet.get(j);
                hOpt.put(a + "#" + b, compute(h.get(a), h.get(b)));
            }
        }
    }

    private Integer compute(ArrayList<Integer> aPos, ArrayList<Integer> bPos) {
        int i = 0, j = 0, m = aPos.size(), n = bPos.size();
        int gMin = Integer.MAX_VALUE;

        while (i < m && j < n) {
            gMin = Math.min(gMin, Math.abs(aPos.get(i) - bPos.get(j)));

            if (aPos.get(i) < bPos.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return gMin;
    }
}
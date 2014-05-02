import java.util.ArrayList;
import java.util.HashMap;

public class min_distance_between_two_words_in_text_preprocessing {
    private HashMap<String, ArrayList<Integer>> h = new HashMap<String, ArrayList<Integer>>();

    /**
     * Get minimum distance between two string in a text file. This function will
     * be called many times.
     * 
     * Also need to ensure "a" is not a substring of "b" and vice versa.
     * 
     */
    public int getMinDistance(String a, String b) {
        ArrayList<Integer> aPos = h.get(a);
        ArrayList<Integer> bPos = h.get(b);

        int i = 0, j = 0;
        int m = aPos.size(), n = bPos.size();
        int result = Integer.MAX_VALUE;

        while (i < m && j < n) {
            result = Math.min(result, Math.abs(aPos.get(i) - bPos.get(j)));
            if (aPos.get(i) > bPos.get(j)) {
                j++;
            } else {
                i++;
            }
        }

        return result;
    }

    public void preprocessing(String text) {
        int len = text.length();

        int j = 0;
        for (int i = 0; i < len; ++i) {
            if (text.charAt(i) == ' ') {
                String t = text.substring(j, i);
                if (!h.containsKey(t)) {
                    h.put(t, new ArrayList<Integer>());
                }

                h.get(t).add(j);
                j = i + 1;
            }
        }

        String t = text.substring(j, len);
        if (!h.containsKey(t)) {
            h.put(t, new ArrayList<Integer>());
        }

        h.get(t).add(j);
    }
}
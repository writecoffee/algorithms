/**
 * You have a large text file containing words. Given any two words, find the shortest distance (in
 * terms of number of words) between them in the file.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain CC150-18.5}
 * 
 */
public class min_distance_between_two_words_in_text_I {
    public int getMinDistance(String[] words, String a, String b) {
        int gMin = Integer.MAX_VALUE;
        int aPos = -1, bPos = -1;
        int n = words.length;

        for (int i = 0; i < n; ++i) {
            if (words[i].equals(a)) {
                aPos = i;
            } else if (words[i].equals(b)) {
                bPos = i;
            }

            if (aPos != -1 && bPos != -1) {
                gMin = Math.min(gMin, Math.abs(aPos - bPos));
            }
        }

        return gMin;
    }
}
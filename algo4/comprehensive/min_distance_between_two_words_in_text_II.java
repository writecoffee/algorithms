import java.util.ArrayList;

/**
 * You have a large text file containing words (may contain punctuation). Given any two words, find
 * the shortest distance (in terms of number of characters) between them in the file. Assume the
 * function will only be called once, so there is no need to do pre-processing.
 * 
 * Also if string a is a substring of string b, such as a = "x" and b = "xx", then we should ensure
 * a and b is an exact whole word in the text.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain CC150-18.5}
 * 
 */
public class min_distance_between_two_words_in_text_II {
    public int getMinDistance(String text, String a, String b) {
        ArrayList<Integer> positions = getWordPos(text);

        int m = a.length(), n = b.length();
        int gMin = Integer.MAX_VALUE;
        int aPos = -1, bPos = -1;

        for (int pos : positions) {
            if (!Character.isLetter(text.charAt(pos + m)) && text.substring(pos, pos + m).equals(a)) {
                aPos = pos;
            } else if (!Character.isLetter(text.charAt(pos + m)) && text.substring(pos, pos + n).equals(b)) {
                bPos = pos;
            }

            if (aPos != -1 && bPos != -1) {
                gMin = Math.min(gMin, Math.abs(aPos - bPos));
            }
        }

        return gMin;
    }

    private ArrayList<Integer> getWordPos(String text) {
        int n = text.length();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0, j = -1; i < n; ++i) {
            if (!Character.isLetter(text.charAt(i)) && j != -1) {
                result.add(j);
                j = -1;
            } else if (Character.isLetter(text.charAt(i)) && j == -1) {
                j = i;
            }
        }

        return result;
    }
}
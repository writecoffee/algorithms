public class min_distance_between_two_words_in_text {
    /**
     * Get minimum distance between two string in a text file. Assume the function will only
     * be called once, so there is no need to do pre-processing.
     * 
     * Also need to ensure "a" is not a substring of "b" and vice versa.
     * 
     */
    public int getMinDistance(String text, String a, String b) {
        int len = text.length();
        int m = a.length(), n = b.length();
        int result = Integer.MAX_VALUE;
        int j = -1, k = -1;

        int i = 0;
        while (i < len) {
            if (text.substring(i, i + m).equals(a)) {
                j = i;
                i += m;
                result = k == -1 ? result : Math.min(result, j - k);
            } else if (text.substring(i, i + n).equals(b)) {
                k = i;
                i += n;
                result = j == -1 ? result : Math.min(result, k - j);
            }
        }

        return result;
    }
}
/**
 * Given: a string T containing up to 10^7 characters from 'a' to 'z' a stream S of smaller
 * strings. Each of the smaller strings S_i is up to 100 characters long. There may be up to
 * 10^8 small strings in S, you are given these one at a time.
 * 
 * For each S_i, determine whether it is a subsequence of T.
 * 
 *     T = 'abcdeab'
 * 
 *     S_1 = 'ade' => True
 *     S_2 = 'edc' => False
 *     S_3 = 'aa' => True
 *     S_4 = 'aaa' => False
 * 
 * O(26 |T|) space complexity to accelerate the query speed.
 * 
 * For each entry in the processing table, nextPos[c][i] represents the next occurrence
 * position in T for character c, from position i.
 * 
 * O(100) Time complexity for query.
 * 
 */
public class process_query_determine_subsequence_II {
    private int[][] nextPos;

    public void preprocessing(String T) {
        int n = T.length();
        nextPos = new int[26][n];

        for (int i = 0; i < 26; ++i) {
            char c = (char) ('a' + i);
            int label = -1;

            for (int j = n - 1; j >= 0; --j) {
                if (T.charAt(j) == c) {
                    label = j;
                }

                nextPos[i][j] = label;
            }
        }
    }

    public boolean isSubsequence(String S) {
        int n = S.length();
        int prePos = -1;

        for (int i = 0; i < n; ++i) {
            char c = S.charAt(i);

            if (nextPos[c - 'a'][prePos + 1] == -1) {
                return false;
            } else {
                prePos = nextPos[c - 'a'][prePos + 1];
            }
        }

        return true;
    }
}
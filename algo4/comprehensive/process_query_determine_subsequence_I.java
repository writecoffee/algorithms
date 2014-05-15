import java.util.ArrayList;
import java.util.HashMap;

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
 */
public class process_query_determine_subsequence_I {
    private HashMap<Character, ArrayList<Integer>> hPos;

    public void preprocessing(String T) {
        hPos = new HashMap<Character, ArrayList<Integer>>();
        int n = T.length();

        for (char c = 'a'; c <= 'z'; ++c) {
            hPos.put(c, new ArrayList<Integer>());
        }

        for (int i = 0; i < n; ++i) {
            char c = T.charAt(i);
            hPos.get(c).add(i);
        }
    }

    public boolean isSubsequence(String S) {
        int n = S.length();
        int prePos = -1;

        for (int i = 0; i < n; ++i) {
            char c = S.charAt(i);

            ArrayList<Integer> pos = hPos.get(c);
            int nxtPos = getPos(pos, prePos + 1);
            if (nxtPos == -1) {
                return false;
            } else {
                prePos = nxtPos;
            }
        }

        return true;
    }

    private int getPos(ArrayList<Integer> pos, int start) {
        if (pos.isEmpty() || pos.get(pos.size() - 1) < start) {
            return -1;
        }

        int l = 0, r = pos.size() - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (pos.get(mid) == start) {
                r = mid - 1;
            } else if (pos.get(mid) < start) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return pos.get(l);
    }
}
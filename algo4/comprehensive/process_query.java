import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * You're given a large string T. And a stream of smaller string S1, S2, S3 ...
 * 
 * Determine whether Si is a subsequence of T.
 * 
 * |T| < 10 000 000 |Si| < 100 alphabet is 'a' - 'z'
 * 
 * T = abcdefg 
 * S1 = abc  yes
 * S2 = ag   yes
 * S3 = ga   no 
 * S4 = aa   no
 * 
 */
public class process_query {
    ArrayList<String> sortedData;

    public void initWithString(String data) {
        int n = data.length();
        HashSet<String> allStrs = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            allStrs.add(data.substring(i, Math.min(n, i + 10)));
        }
        sortedData = new ArrayList<String>(allStrs);
        Collections.sort(sortedData);
    }

    public boolean existSubString(String query) {
        int i = 0;
        int j = sortedData.size() - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            String midStr = sortedData.get(mid);

            if (midStr.equals(query) || midStr.startsWith(query)) {
                return true;
            } else if (midStr.compareTo(query) < 0) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }
}
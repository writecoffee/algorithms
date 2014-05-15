import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class process_query_determine_substring {
    ArrayList<String> sortedData;

    /**
     * The length of the data string is of length n. There are many query
     * which length is no bigger than 10. To determine whether the input
     * query string is a substring of the data string.
     * 
     * Pre-process the data then do binary search. O(10 n) space complexity
     * and O(log n + 10) time complexity for each query.
     */
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
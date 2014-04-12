import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class word_ladder {
    /**
     * Using breath-first-search to probe the minimum distance is an optimal
     * solution; otherwise using depth-first-search would require exploring
     * every "node" and compute the minimum.
     * 
     */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        HashMap<String, Integer> hDist = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        q.add(start);
        hDist.put(start, 1);

        while (!q.isEmpty()) {
            String c = q.poll();
            int d = hDist.get(c);

            if (c.equals(end)) {
                return d;
            }

            for (int i = 0; i < c.length(); ++i) {
                for (char j = 'a'; j <= 'z'; ++j) {
                    char[] cStr = c.toCharArray();
                    cStr[i] = j;
                    String t = new String(cStr);

                    if (dict.contains(t)) {
                        q.add(t);
                        hDist.put(t, d + 1);
                        dict.remove(t);
                    }
                }
            }
        }

        return 0;
    }
}

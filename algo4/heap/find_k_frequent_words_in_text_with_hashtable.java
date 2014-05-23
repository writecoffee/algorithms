import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class find_k_frequent_words_in_text_with_hashtable {
    private class WordNode {
        private final String s;
        private int freq;

        private WordNode(final String _s) {
            s = _s;
            freq = 1;
        }

        public void incFreq() {
            freq++;
        }
    }

    /**
     * Tries tend to be faster on average at insertion than hash tables because hash tables must
     * rebuild their index when it becomes full - a very expensive operation. Tries therefore have
     * much better bounded worst-case time costs, which is important for latency-sensitive programs.
     * 
     */
    public String findKthWords(String[] text, int k) {
        HashMap<String, WordNode> h = new HashMap<String, WordNode>(text.length);
        for (String s : text) {
            if (h.containsKey(s)) {
                h.get(s).incFreq();
            } else {
                h.put(s, new WordNode(s));
            }
        }

        Queue<WordNode> pq = new PriorityQueue<WordNode>(k, new Comparator<WordNode>() {
            @Override
            public int compare(WordNode a, WordNode b) {
                return a.freq - b.freq;
            }
        });

        int i = 0;
        for (Entry<String, WordNode> ent : h.entrySet()) {
            if (i++ >= k) {
                if (pq.peek().freq < ent.getValue().freq) {
                    pq.poll();
                    pq.add(ent.getValue());
                }
            } else {
                pq.add(ent.getValue());
            }
        }

        return pq.poll().s;
    }
}
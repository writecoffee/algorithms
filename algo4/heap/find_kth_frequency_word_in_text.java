import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class find_kth_frequency_word_in_text {
    class WordNode {
        final String s;
        private int freq;

        WordNode(final String _s, final Integer _freq) {
            s = _s;
            freq = _freq;
        }

        public void incFreq() {
            freq++;
        }
    }

    /**
     * Tries tend to be faster on average at insertion than hash tables because hash tables must
     * rebuild their index when it becomes full - a very expensive operation. Tries therefore have
     * much better bounded worst-case time costs, which is important for latency-sensitive programs.
     */
    public String findKthWord(String[] text, int k) {
        HashMap<String, WordNode> h = new HashMap<String, WordNode>(text.length);
        for (String s : text) {
            if (h.containsKey(s)) {
                h.get(s).incFreq();
            } else {
                h.put(s, new WordNode(s, 1));
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
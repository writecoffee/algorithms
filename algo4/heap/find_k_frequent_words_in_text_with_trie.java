import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class find_k_frequent_words_in_text_with_trie {
    private class TrieNode {
        private final Character c;
        private TrieNode parent;
        private final HashMap<Character, TrieNode> children;
        private int freq;

        private TrieNode(Character _c, TrieNode _parent) {
            c = _c;
            children = new HashMap<Character, TrieNode>();
            parent = _parent;
            freq = 0;
        }

        public void addChild(Character c) {
            children.put(c, new TrieNode(c, this));
        }

        public TrieNode getChild(Character c) {
            return children.get(c);
        }

        public void setFinal() {
            freq++;
        }
    }

    public ArrayList<String> findKWords(String[] text, int k) {
        PriorityQueue<TrieNode> pq = new PriorityQueue<TrieNode>(k, new Comparator<TrieNode>() {
            @Override
            public int compare(TrieNode a, TrieNode b) {
                return a.freq - b.freq;
            }
        });

        int n = text.length;
        int i = 0;
        TrieNode root = new TrieNode(' ', null);
        HashSet<TrieNode> hContained = new HashSet<TrieNode>();

        for (; i < n && pq.size() < k; ++i) {
            TrieNode leaf = exploreTrie(root, text[i].toCharArray());
            if (!hContained.contains(leaf)) {
                hContained.add(leaf);
                pq.add(leaf);
            }
        }

        for (; i < n; ++i) {
            TrieNode leaf = exploreTrie(root, text[i].toCharArray());

            if (hContained.contains(leaf)) {
                pq.remove(leaf);
                pq.add(leaf);
            } else if (pq.peek().freq > leaf.freq) {
                continue;
            } else if (pq.peek().freq < leaf.freq) {
                hContained.remove(pq.poll());
                hContained.add(leaf);
                pq.add(leaf);
            }
        }

        ArrayList<String> result = new ArrayList<String>();
        while (!pq.isEmpty()) {
            result.add(backtrack(pq.poll()));
        }

        return result;
    }

    private TrieNode exploreTrie(TrieNode root, char[] chars) {
        int n = chars.length;
        TrieNode c = root;

        for (int i = 0; i < n; ++i) {
            if (!c.children.containsKey(chars[i])) {
                c.addChild(chars[i]);
            }

            c = c.getChild(chars[i]);
        }

        c.setFinal();
        return c;
    }

    private String backtrack(TrieNode leaf) {
        StringBuilder sb = new StringBuilder();

        TrieNode c = leaf;
        while (c != null) {
            sb.append(c.c);
            c = c.parent;
        }

        return sb.reverse().toString();
    }
}
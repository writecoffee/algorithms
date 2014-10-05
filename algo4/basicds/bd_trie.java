/**
 * Implement Trie.
 *
 * [Difficulty]     - Medium
 * [Tediousness]    - High
 * [Source]         - {@linkplain https://leetcode.com/submissions/detail/32564627/}
 *
 */
public class bd_trie
{
    class TrieNode
    {
        public final TrieNode[] children = new TrieNode[26];
        public final char       ch;
        private boolean         leaf;

        public boolean isLeaf()
        {
            return leaf;
        }

        public void flipLeaf()
        {
            leaf = true;
        }

        public TrieNode(char _ch)
        {
            ch = _ch;
        }

        public boolean hasNext(char ch)
        {
            return null != children[ch - 'a'];
        }

        public void addChild(char ch)
        {
            children[ch - 'a'] = new TrieNode(ch);
        }

        public TrieNode next(char ch)
        {
            return children[ch - 'a'];
        }
    }

    private TrieNode root;

    public bd_trie()
    {
        root = new TrieNode('.');
    }

    public void insert(String word)
    {
        TrieNode c = root;

        for (char ch : word.toCharArray()) {
            if (!c.hasNext(ch)) {
                c.addChild(ch);
            }

            c = c.next(ch);
        }

        c.flipLeaf();
    }

    public boolean search(String word)
    {
        TrieNode c = root;

        for (char ch : word.toCharArray()) {
            if (!c.hasNext(ch)) {
                return false;
            }

            c = c.next(ch);
        }

        return c.isLeaf();
    }

    public boolean startsWith(String prefix)
    {
        TrieNode c = root;

        for (char ch : prefix.toCharArray()) {
            if (!c.hasNext(ch)) {
                return false;
            }

            c = c.next(ch);
        }

        return true;
    }
}

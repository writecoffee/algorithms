package trie;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 *
 * bool search(word)
 *
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one letter.
 *
 * For example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 *
 * Note:
 *
 * You may assume that all words are consist of lowercase letters a-z.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/add-and-search-word-data-structure-design/}
 * [Tag]        - $trie$
 *
 */
public class tr_search_word_in_dictionary_using_trie
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

    private TrieNode root = new TrieNode('.');

    public boolean search(String word)
    {
        return dfs(word.toCharArray(), 0, word.length(), root);
    }

    private boolean dfs(char[] word, int i, int n, TrieNode c)
    {
        if (i == n) {
            return c.isLeaf();
        }

        char ch = word[i];

        if (ch != '.' && !c.hasNext(ch)) {
            return false;
        } else if (ch == '.') {
            for (TrieNode next : c.children) {
                if (next != null && dfs(word, i + 1, n, next)) {
                    return true;
                }
            }

            return false;
        } else {
            return dfs(word, i + 1, n, c.next(ch));
        }
    }

    public void addWord(String word)
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
}

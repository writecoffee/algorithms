package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words
 * in the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 *
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * Return ["eat","oath"].
 *
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/word-search/}
 * [Tag]        - $trie$
 *
 */
public class tr_search_word_in_grid_using_trie_II
{
    private class TrieNode
    {
        private final HashMap<Character, TrieNode> children;
        private boolean                            isEnd   = false;
        private boolean                            visited = false;

        private TrieNode(char _c)
        {
            children = new HashMap<Character, TrieNode>();
        }

        private void addChild(char c)
        {
            children.put(c, new TrieNode(c));
        }

        private boolean hasChild(char c)
        {
            return children.containsKey(c);
        }

        private TrieNode getChild(char c)
        {
            return children.get(c);
        }
    }

    public List<String> findWords(char[][] board, String[] patterns)
    {
        int m = board.length, n = board[0].length;
        List<String> result = new ArrayList<String>();
        TrieNode root = new TrieNode('*');

        for (String s : patterns) {
            preprocess(root, s);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                explore(board, m, n, root, i, j, result, new StringBuilder());
            }
        }

        return result;
    }

    private void preprocess(TrieNode root, String pattern)
    {
        TrieNode tn = root;

        for (int i = 0; i < pattern.length(); ++i) {
            char c = pattern.charAt(i);

            if (!tn.hasChild(c)) {
                tn.addChild(c);
            }

            tn = tn.getChild(c);
        }

        tn.isEnd = true;
    }

    private void explore(char[][] board,
                         int m,
                         int n,
                         TrieNode c,
                         int i,
                         int j,
                         List<String> result,
                         StringBuilder path)
    {
        if (i < 0 || j < 0 || i == m || j == n || board[i][j] == '#' || !c.hasChild(board[i][j])) {
            return;
        }

        char ch = board[i][j];
        path.append(ch);

        if (c.hasChild(ch) && c.getChild(ch).isEnd && !c.getChild(ch).visited) {
            result.add(path.toString());
            c.getChild(ch).visited = true;
        }

        TrieNode child = c.getChild(ch);
        board[i][j] = '#';

        explore(board, m, n, child, i - 1, j, result, path);
        explore(board, m, n, child, i, j - 1, result, path);
        explore(board, m, n, child, i + 1, j, result, path);
        explore(board, m, n, child, i, j + 1, result, path);

        path.deleteCharAt(path.length() - 1);
        board[i][j] = ch;
    }
}

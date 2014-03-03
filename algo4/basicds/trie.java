public class trie {
    public static class TrieNode {
        public final char letter;
        public final TrieNode[] links;
        private boolean isFullWord;

        public boolean isFullWord() {
            return isFullWord;
        }

        public void setFullWord() {
            isFullWord = true;
        }

        public TrieNode(char _letter) {
            letter = _letter;
            links = new TrieNode[26];
        }
    }

    public static void insertWord(TrieNode root, String word) {
        int offset = 97;
        int len = word.length();
        char[] letters = word.toCharArray();
        TrieNode currNode = root;

        for (int i = 0; i < len; i++) {
            if (currNode.links[letters[i] - offset] == null) {
                currNode.links[letters[i] - offset] = new TrieNode(letters[i]);
            }

            currNode = currNode.links[letters[i] - offset];
        }

        currNode.setFullWord();
    }

    public static boolean find(TrieNode root, String word) {
        char[] letters = word.toCharArray();
        int len = letters.length;
        int offset = 97;
        TrieNode currNode = root;

        for (int i = 0; i < len; i++) {
            if (currNode == null) {
                return false;
            }

            currNode = currNode.links[letters[i] - offset];
        }

        if (currNode == null || !currNode.isFullWord()) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        TrieNode tree = new TrieNode('\0');

        String[] words = { "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be", "an" };
        for (int i = 0; i < words.length; i++) {
            insertWord(tree, words[i]);
        }

        assert find(tree, "a") == false;
        assert find(tree, "an") == true;
        assert find(tree, "all") == true;
        assert find(tree, "alg") == false;
        assert find(tree, "allott") == false;
    }
}
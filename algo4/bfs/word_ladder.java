import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class word_ladder {
    public static class WordNode {
        final char[] cstrWord;
        final int step;

        public WordNode(char[] _cstrWord, int _step) {
            cstrWord = _cstrWord;
            step = _step;
        }
    }

    public static int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<WordNode> q = new LinkedList<WordNode>();
        q.add(new WordNode(start.toCharArray(), 1));

        while (!q.isEmpty()) {
            WordNode node = q.poll();
            char[] word = node.cstrWord;

            for (int i = 0; i < word.length; ++i) {
                char before = word[i];

                for (char j = 'a'; j <= 'z'; ++j) {
                    word[i] = j;
                    String newString = new String(word);

                    if (newString.equals(end)) {
                        return node.step + 1;
                    }

                    if (dict.contains(newString)) {
                        q.add(new WordNode(word.clone(), node.step + 1));
                        dict.remove(newString);
                    }
                }

                word[i] = before;
            }
        }

        return 0;
    }

    static int minLen;
    public static int ladderLengthFoolishDFS(String start, String end, HashSet<String> dict) {
        minLen = Integer.MAX_VALUE;
        dfs(start, end, dict, 1);
        return Integer.MAX_VALUE == minLen ? 0 : minLen;
    }

    public static int dfs(String start, String end, HashSet<String> dict, int step) {
        char[] cstr = start.toCharArray();

        for (int i = 0; i < start.length(); ++i) {
            char before = cstr[i];

            for (char j = 'a'; j <= 'z'; ++j) {
                cstr[i] = j;
                String newStr = new String(cstr);

                if (newStr.equals(end)) {
                    minLen = minLen > step + 1 ? step + 1 : minLen;
                    return step + 1;
                } else if (dict.contains(newStr)) {
                    dict.remove(newStr);

                    if (dfs(newStr, end, dict, step + 1) == 0) {
                        dict.add(newStr);
                    }
                }
            }

            cstr[i] = before;
        }

        return 0;
    }

    public static HashSet<String> testDict = new HashSet<String>();
    static {
        testDict.add("dog");
        testDict.add("hot");
        testDict.add("dot");
        testDict.add("log");
        testDict.add("cog");
    }

    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", testDict));
    }
}

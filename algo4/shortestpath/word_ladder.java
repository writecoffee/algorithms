import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class word_ladder {
    public static class Pair {
        final char[] first;
        final int second;

        Pair(final char[] first, final int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(start.toCharArray(), 1));

        while (!q.isEmpty()) {
            Pair front = q.poll();
            char[] frontWord = front.first;

            for (int i = 0; i < frontWord.length; i++) {
                char before = frontWord[i];

                for (char c = 'a'; c < 'z'; c++) {
                    char[] newWordArray = frontWord.clone();
                    newWordArray[i] = c;
                    String newWord = new String(newWordArray);

                    if (newWord.equals(end)) {
                        return front.second + 1;
                    }

                    if (dict.contains(newWord)) {
                        q.add(new Pair(newWordArray, front.second + 1));
                        dict.remove(newWord);
                    }
                }

                frontWord[i] = before;
            }
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

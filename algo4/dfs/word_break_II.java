import java.util.ArrayList;
import java.util.Set;

public class word_break_II {
    /**
     * Use depth-first-search method to partition the string into smaller word sequences.
     * If we can reach the termination (start == n), then there is a successful word break
     * sequences.
     * 
     * Because the depth-first-search routine runs in exponential time complexity, we 
     * can detect whether there is a word break sequence firstly by spending O(n^2) time.
     */
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if (!hasBreak(s, dict)) {
            return result;
        }

        explore(s, 0, dict, new ArrayList<String>(), result);
        return result;
    }

    public void explore(String s, int start, Set<String> dict, ArrayList<String> path, ArrayList<String> result) {
        int n = s.length();

        if (start == n) {
            result.add(pathToSentence(path));
            return;
        }

        for (int i = start + 1; i <= n; ++i) {
            String w = s.substring(start, i);
            if (dict.contains(w)) {
                path.add(w);
                explore(s, i, dict, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean hasBreak(String s, Set<String> dict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i < n + 1; ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public String pathToSentence(ArrayList<String> path) {
        StringBuilder sb = new StringBuilder();
        for (String s : path) {
            sb.append(s);
            sb.append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
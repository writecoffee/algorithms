package pruning;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * 
 * Return
 * 
 *   [
 *     ["aa", "b"],
 *     ["a", "a", "b"]
 *   ]
 *
 */
public class all_palindrome_partitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        explore(s, 0, new ArrayList<String>(), preprocess(s, s.length()), result);
        return result;
    }

    private void explore(String s, int start, ArrayList<String> path, boolean[][] isPalin, ArrayList<ArrayList<String>> result) {
        int n = s.length();

        if (start == n) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = start; i < n; ++i) {
            String t = s.substring(start, i + 1);

            if (isPalin[start][i]) {
                path.add(t);
                explore(s, i + 1, path, isPalin, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean[][] preprocess(String s, int n) {
        boolean[][] isPalin = new boolean[n][n];

        for (int i = 0; i < n; ++i) {
            isPalin[i][i] = true;
        }

        for (int i = 0; i < n - 1; ++i) {
            isPalin[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i <= n - k; ++i) {
                isPalin[i][i + k - 1] = s.charAt(i) == s.charAt(i + k - 1) && isPalin[i + 1][i + k - 2];
            }
        }

        return isPalin;
    }
}
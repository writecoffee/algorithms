package pruning;

import java.util.ArrayList;
import java.util.Stack;

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
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/palindrome-partitioning/}
 * 
 */
public class dfs_all_palindrome_partitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        explore(s, 0, s.length(), new Stack<String>(), result, preprocess(s));
        return result;
    }

    private void explore(String s, int i, int n, Stack<String> path, ArrayList<ArrayList<String>> result, boolean[][] isPalin) {
        if (i == n) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int j = i + 1; j <= n; ++j) {
            if (isPalin[i][j - 1]) {
                path.push(s.substring(i, j));
                explore(s, j, n, path, result, isPalin);
                path.pop();
            }
        }
    }

    private boolean[][] preprocess(String s) {
        int n = s.length();
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
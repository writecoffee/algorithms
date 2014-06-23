package probe;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * The function prototype should be:
 * 
 * Sample Input:
 * 
 * isMatch("aa","a") => false
 * isMatch("aa","aa") => true
 * isMatch("aaa","aa") => false
 * isMatch("aa", "a*") => true
 * isMatch("aa", ".*") => true
 * isMatch("ab", ".*") => true
 * isMatch("aab", "c*a*b") => true
 * 
 * [Difficulty] - Hard
 * [Source]     - facebook interview, {@linkplain https://oj.leetcode.com/problems/regular-expression-matching/}
 *
 */
public class dfs_regular_expression_matching {
    /**
     * The optimal solution is to make no more than 2 dfs branches, if there are three branches,
     * time complexity would be more than O(3^m), which is no good.
     * 
     * Just one word, if next character is '*', swallow one more character in input string or
     * stay still by skipping the '*' matching.
     * 
     */
    public boolean isMatch(String s, String p) {
        return explore(s.concat("\0").toCharArray(), 0, s.length(), p.concat("\0").toCharArray(), 0, p.length());
    }

    private boolean explore(char[] s, int i, int m, char[] p, int j, int n) {
        if (i == m && j == n) {
            return true;
        } else if (j == n || i > m) {
            return false;
        }

        if (s[i] == p[j] || p[j] == '.') {
            if (p[j + 1] == '*') {
                return explore(s, i + 1, m, p, j, n) || explore(s, i, m, p, j + 2, n);
            } else {
                return explore(s, i + 1, m, p, j + 1, n);
            }
        } else {
            return p[j + 1] == '*' && explore(s, i, m, p, j + 2, n);
        }
    }
}
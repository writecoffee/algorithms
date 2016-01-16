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
 * [Source]     - facebook interview,
 *                {@linkplain https://oj.leetcode.com/problems/regular-expression-matching/}
 *
 */
public class dfs_regular_expression_matching
{
    /**
     * The optimal solution is to make no more than 2 dfs branches, if there are three branches,
     * time complexity would be more than O(3^m), which is no good.
     *
     * Just one word, if next character is '*', swallow one more character in input string or
     * stay still by skipping the '*' matching.
     *
     */
    public boolean isMatch(String s, String p)
    {
        return explore((s + '\n').toCharArray(), 0, (p + '\n').toCharArray(), 0);
    }

    private boolean explore(char[] s, int i, char[] p, int j)
    {
        if (i == s.length - 1 && j == p.length - 1) {
            return true;
        }
        /*
         * As for condition "i == s.length", consider input case { "aa", "a*" },
         */
        else if (i == s.length || j == p.length - 1) {
            return false;
        }

        boolean charMatch = s[i] == p[j] || p[j] == '.';
        if (charMatch && p[j + 1] == '*') {
            return explore(s, i + 1, p, j) || explore(s, i, p, j + 2);
        } else if (charMatch) {
            return explore(s, i + 1, p, j + 1);
        } else if (!charMatch && p[j + 1] == '*') {
            return explore(s, i, p, j + 2);
        } else {
            return false;
        }
    }
}

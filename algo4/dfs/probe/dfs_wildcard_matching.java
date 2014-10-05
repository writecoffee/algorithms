package probe;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Sample input:
 *
 *   isMatch("aa","a") => false
 *   isMatch("aa","aa") => true
 *   isMatch("aaa","aa") => false
 *   isMatch("aa", "*") => true
 *   isMatch("aa", "a*") => true
 *   isMatch("ab", "?*") => true
 *   isMatch("aab", "c*a*b") => false
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/wildcard-matching/}
 *
 */
public class dfs_wildcard_matching {
    /**
     * If i reaches the end of 's', we need to see whether p[j] is '*' or not, if p[j] is '*',
     * we can try skipping the current '*' and probe to till the end of 'p'.
     *
     */
    public boolean isMatch(String s, String p)
    {
        return explore(s.concat("\0"), 0, s.length(), p.concat("\0"), 0, p.length());
    }

    private boolean explore(String s, int i, int m, String p, int j, int n)
    {
        char c1 = s.charAt(i), c2 = p.charAt(j);

        if (i == m && j == n) {
            return true;
        } else if (j == n) {
            return false;
        } else if (i == m && c2 != '*') {
            return false;
        } else if (i == m && c2 == '*') {
            return explore(s, i, m, p, j + 1, n);
        } else if (c2 == '*' && p.charAt(j + 1) == '*') {
            return explore(s, i, m, p, j + 1, n);
        }

        if (c1 == c2 || c2 == '?') {
            return explore(s, i + 1, m, p, j + 1, n);
        } else if (c2 == '*') {
            return explore(s, i + 1, m, p, j, n) || explore(s, i, m, p, j + 1, n);
        } else {
            return false;
        }
    }

    public boolean isMatchNonrecur(String s, String p)
    {
        int i = 0, j = 0, iBack = -1, jBack = -1, m = s.length(), n = p.length();

        s = s.concat("\0");
        p = p.concat("\0");

        while (i < m) {
            int c1 = s.charAt(i), c2 = p.charAt(j);

            if (c2 == '?' || c1 == c2) {
                i++;
                j++;
            } else if (c2 == '*' && p.charAt(j + 1) == '*') {
                j++;
            } else if (c2 == '*') {
                iBack = i;
                jBack = ++j;
            } else if (iBack == -1) {
                return false;
            } else {
                i = ++iBack;
                j = jBack;
            }
        }

        while (p.charAt(j) == '*') {
            ++j;
        }

        return i == m && j == n;
    }
}

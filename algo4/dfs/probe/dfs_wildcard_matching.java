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
        char sc = s.charAt(i), pc = p.charAt(j);

        if (i == m && j == n) {
            return true;
        } else if (j == n) {
            return false;
        } else if (i == m && pc != '*') {
            return false;
        } else if (i == m && pc == '*') {
            return explore(s, i, m, p, j + 1, n);
        }

        if (sc == pc || pc == '?') {
            return explore(s, i + 1, m, p, j + 1, n);
        } else if (pc == '*') {
            return explore(s, i + 1, m, p, j, n) || explore(s, i, m, p, j + 1, n);
        } else {
            return false;
        }
    }

    public boolean isMatchNonrecur(String t, String p)
    {
        int i = 0;
        int j = 0;
        int iPivot = -1;
        int jPivot = -1;
        int m = t.length();
        int n = p.length();

        while (i < m) {
            char tc = t.charAt(i);
            char pc = p.charAt(j);

            if (pc == '?' || tc == pc) {
                i++;
                j++;
            } else if (pc == '*') {
                iPivot = i;
                jPivot = ++j;
            // no pivot, no '*', break
            } else if (iPivot == -1) {
                return false;
            // backtrack
            } else {
                i = ++iPivot;
                j = jPivot;
            }
        }

        while (j < n && p.charAt(j) == '*') {
            ++j;
        }

        return i == m && j == n;
    }
}

package backtracking;

public class regular_expression_matching {
    /**
     * Go through the following 3 test cases, the problem will be hacked!
     * 
     *      (1) s = "abbc", p = "ab*bbc"
     *      (2) s = "aa", p = "a*"
     *      (3) s = "", p = "."
     * 
     */
    public boolean isMatch(String s, String p) {
        return explore(s.concat("\0").toCharArray(), 0, p.concat("\0").toCharArray(), 0);
    }

    private boolean explore(char[] s, int i, char[] p, int j) {
        if (p[j] == '\0') {
            return i != s.length && s[i] == '\0';
        } else if (i == s.length) {
            return false;
        }

        if (s[i] == p[j] || p[j] == '.') {
            if (p[j + 1] == '*') {
                return explore(s, i + 1, p, j) || explore(s, i, p, j + 2);
            } else {
                return explore(s, i + 1, p, j + 1);
            }
        } else {
            return p[j + 1] == '*' && explore(s, i, p, j + 2);
        }
    }
}
package probe;

public class wildcard_matching {
    /**
     * Test cases that need to go through:
     * 
     *      (1) s = "aa", p = "*"
     *      (2) s = "hi", p = "*?"
     */
    public boolean isMatch(String s, String p) {
        s = new String(s + '\0');
        p = new String(p + '\0');

        int i = 0;
        int j = 0;
        int iBack = -1;
        int jBack = -1;

        while (s.charAt(i) != '\0') {
            if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                while (p.charAt(j) == '*') {
                    j++;
                }

                iBack = i;
                jBack = j;
            } else {
                if (iBack == -1) {
                    return false;
                }

                i = ++iBack;
                j = jBack;
            }
        }

        while (p.charAt(j) == '*') {
            ++j;
        }

        return s.charAt(i) == '\0' && p.charAt(j) == '\0';
    }
}
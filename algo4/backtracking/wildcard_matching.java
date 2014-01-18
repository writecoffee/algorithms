public class wildcard_matching {

    public static boolean isMatch(String s, String p) {
        int sBackup = -1;
        int pBackup = -1;

        s = new String(s + '\0');
        p = new String(p + '\0');

        int i = 0;
        int j = 0;
        while (s.charAt(i) != '\0') {
            if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                i++;
                j++;
            } else if (p.charAt(j) == '*') {
                while (p.charAt(j) == '*') {
                    j++;
                }

                if (p.charAt(j) == '\0') {
                    return true;
                }

                sBackup = i;
                pBackup = j;
            } else {
                if (sBackup == -1) {
                    return false;
                }

                i = ++sBackup;
                j = pBackup;
            }
        }

        while (p.charAt(j) == '*') {
            ++j;
        }

        return s.charAt(i) == '\0' && p.charAt(j) == '\0';
    }

    public static void main(String[] args) {
        System.out.println(isMatch("ab", "?*"));
        System.out.println(isMatch("aa", "*"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("hi", "*?"));
    }
}
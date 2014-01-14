public class regular_expression_matching {

    public static boolean isMatch(String s, String p) {
        s = s.concat("\0");
        p = p.concat("\0");
        return isMatchHelper(s, p);
    }

    public static boolean isMatchHelper(String s, String p) {
        if (p.charAt(0) == '\0') {
            return !s.isEmpty() && s.charAt(0) == '\0';
        }

        if (s.isEmpty()) {
            return false;
        }

        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            if (p.charAt(1) == '*') {
                return isMatchHelper(s.substring(1), p) || isMatchHelper(s, p.substring(2));
            } else {
                return isMatchHelper(s.substring(1), p.substring(1));
            }
        } else {
            return p.charAt(1) == '*' && isMatchHelper(s, p.substring(2));
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("n","m*"));
        System.out.println(isMatch("aa","aa"));
        System.out.println(isMatch("aaa","aa"));
        System.out.println(isMatch("aab", "c*a*b"));
        System.out.println(isMatch(" ", " ."));
        System.out.println(isMatch(" ", " .*"));
        System.out.println(isMatch("aaa", "a*a"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", ".*c"));
        System.out.println(isMatch("", "c*c*"));
    }
}
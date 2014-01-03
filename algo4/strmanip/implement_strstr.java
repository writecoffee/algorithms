public class implement_strstr {

    public static String strStr(String haystack, String needle) {
        if (haystack == null) {
            return null;
        }
        if (needle == null) {
            return null;
        }
        if (needle.length() > haystack.length()) {
            return null;
        }
        if (needle.isEmpty() && haystack.isEmpty()) {
            return "";
        }

        for (int i = 0; i < haystack.length(); i++) {
            int k = i;
            int n = 0;
            while (n != needle.length()
                    && k != haystack.length()
                    && needle.charAt(n) == haystack.charAt(k)) {
                k++;
                n++;
            }
            if (n == needle.length()) {
                return haystack.substring(i);
            }
            if (k == haystack.length()) {
                return null;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", ""));
        System.out.println(strStr("", ""));
        System.out.println(strStr("hello world", "wor"));
        System.out.println(strStr("hello world", "woo"));
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("mississippi", "issipi"));
    }
}

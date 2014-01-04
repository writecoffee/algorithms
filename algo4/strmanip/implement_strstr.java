public class implement_strstr {

    public static String strStrNaive(String haystack, String needle) {
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
    
    public static String strStr(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();

        if (M > N) {
            return null;
        }
        if (M == 0) {
            return haystack;
        }

        int[] overlay = getOverlay(needle);
        int i = 0;

comparing:
        while (i <= N - M) {
            if (needle.charAt(0) != haystack.charAt(i)) {
                i++;
                continue;
            }

            for (int j = 0; j < M; j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    i = i + j - overlay[j - 1];
                    continue comparing;
                }
            }

            return haystack.substring(i);
        }

        return null;
    }

    public static int[] getOverlay(String needle) {
        int[] overlay = new int[needle.length()];
        overlay[0] = 0;

        for (int i = 1; i < overlay.length; i++) {
            int h = overlay[i - 1];
            while (h > 0 && needle.charAt(h) != needle.charAt(i)) {
                h = overlay[h - 1];
            }

            if (needle.charAt(h) == needle.charAt(i)) {
                overlay[i] = overlay[i - 1] + 1;
            } else {
                overlay[i] = 0;
            }
        }
        
        return overlay;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", ""));
        System.out.println(strStr("", ""));
        System.out.println(strStr("hello world", "wor"));
        System.out.println(strStr("hello world", "woo"));
        System.out.println(strStr("aaa", "aaaa"));
        System.out.println(strStr("mississipi", "issipi"));
    }
}

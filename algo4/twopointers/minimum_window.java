public class minimum_window {
    static String minWindow(String S, String T) {
        int[] needed = new int[256];
        int[] found = new int[256];
        
        if (T.length() > S.length()) {
            return "";
        }

        for (int i = 0; i < T.length(); i++) {
            needed[T.charAt(i)]++;
        }

        int start = 0;
        int end = 0;
        int optStart = -1;
        int optEnd = S.length() - 1;
        int needCount = 0;

        for (; end < S.length(); end++) {
            if (needed[S.charAt(end)] == 0) {
                continue;
            }

            if (found[S.charAt(end)] < needed[S.charAt(end)]) {
                needCount++;
            }

            found[S.charAt(end)]++;

            if (needCount == T.length()) {
                while (start < end) {
                    if (needed[S.charAt(start)] == 0) {
                        start++;
                    } else if (found[S.charAt(start)] == needed[S.charAt(start)]) {
                        break;
                    } else {
                        found[S.charAt(start)]--;
                        start++;
                    }
                }

                if (optEnd - optStart > end - start) {
                    optEnd = end;
                    optStart = start;
                }
            }
        }

        return optStart == -1 ? "" : S.substring(optStart, optEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
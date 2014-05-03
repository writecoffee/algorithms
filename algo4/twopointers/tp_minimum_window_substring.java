public class tp_minimum_window_substring {
    String minWindow(String s, String t) {
        int[] needed = new int[256];
        int[] found = new int[256];

        int m = s.length(), n = t.length();
        String result = "";

        for (int i = 0; i < n; ++i) {
            needed[t.charAt(i)]++;
        }

        int i = 0, j = 0, needCnt = 0, l = -1, r = m - 1;

        for (; j < m; ++j) {
            char c = s.charAt(j);

            if (needed[c] == 0) {
                continue;
            }

            needCnt = found[c] < needed[c] ? needCnt + 1 : needCnt;
            found[c]++;

            if (needCnt == n) {
                while (i < j) {
                    if (needed[s.charAt(i)] == 0) {
                        i++;
                    } else if (found[s.charAt(i)] == needed[s.charAt(i)]) {
                        break;
                    } else {
                        found[s.charAt(i)]--;
                        i++;
                    }
                }

                if (j - i + 1 < r - l + 1) {
                    l = i;
                    r = j;
                    result = s.substring(l, r + 1);
                }
            }
        }

        return result;
    }
}
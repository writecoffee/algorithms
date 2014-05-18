package window;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the
 * characters in T in complexity O(n).
 * 
 * For example,
 * 
 * S = "ADOBECODEBANC"
 * 
 * T = "ABC"
 * 
 * Minimum window is "BANC".
 * 
 */
public class tp_minimum_window_substring {
    /**
     * Firstly, we keep expanding the right boundary until we have all characters need for string t.
     * Then when continue moving the right pointer we would get duplicate characters. We can chop
     * off character on the left boundary only if that is not in string t or is redundant (since
     * we are accepting more characters when we are expanding the right boundary).
     * 
     */
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int[] needed = new int[256];
        int[] found = new int[256];

        for (int i = 0; i < n; ++i) {
            needed[t.charAt(i)]++;
        }

        int start = -1, end = m, needCnt = 0;
        for (int l = 0, r = 0; r < m; ++r) {
            char c = s.charAt(r);

            if (needed[c] == 0) {
                continue;
            } else {
                found[c]++;

                if (found[c] <= needed[c]) {
                    needCnt++;
                }
            }

            if (needCnt == n) {
                for (; l < r; ++l) {
                    if (needed[s.charAt(l)] == 0) {
                        continue;
                    } else if (found[s.charAt(l)] > needed[s.charAt(l)]) {
                        found[s.charAt(l)]--;
                    } else {
                        break;
                    }
                }

                end = r - l < end - start ? r : end;
                start = r - l < end - start ? l : start;
            }
        }

        return start == -1 ? "" : s.substring(start, end + 1);
    }
}
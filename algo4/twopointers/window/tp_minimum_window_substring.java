package window;

/**
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 *
 * For example,
 *
 * S = "ADOBECODEBANC"
 *
 * T = "ABC"
 *
 * Minimum window is "BANC".
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/minimum-window-substring/}
 * [Difficulty] - Medium
 *
 */
public class tp_minimum_window_substring
{
    public String minWindowOptimized(String s, String t)
    {
        int n = s.length();
        int ri = 0, rlen = Integer.MAX_VALUE;
        int[] hs = new int[256],
              ht = new int[256];
        int fulfillCount = 0,
            targetCount = 0;

        for (char c : t.toCharArray()) {
            ht[c]++;

            if (ht[c] == 1) {
                targetCount++;
            }
        }

        for (int i = 0, j = 0; i < n; i++) {
            for (; j < n && targetCount != fulfillCount; j++) {
                char c = s.charAt(j);

                if (ht[c] > 0 && hs[c] + 1 == ht[c]) {
                    fulfillCount++;
                }

                hs[c]++;
            }

            if (targetCount == fulfillCount && j - i < rlen) {
                rlen = j - i;
                ri = i;
            }

            char back = s.charAt(i);
            if (ht[back] > 0 && hs[back] == ht[back]) {
                fulfillCount--;
            }

            hs[back]--;
        }

        if (rlen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(ri, ri + rlen);
        }
    }

    public String minWindow(String s, String t)
    {
        int n = s.length();
        int ri = 0, rlen = Integer.MAX_VALUE;
        int[] sh = new int[256],
              ht = new int[256];

        for (char c : t.toCharArray()) {
            ht[c]++;
        }

        for (int i = 0, j = 0; i < n; i++) {
            for (; j < n && !fulfilled(sh, ht); j++) {
                sh[s.charAt(j)]++;
            }

            if (fulfilled(sh, ht) && j - i < rlen) {
                rlen = j - i;
                ri = i;
            }

            sh[s.charAt(i)]--;
        }

        if (rlen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(ri, ri + rlen);
        }
    }

    private boolean fulfilled(int[] h, int[] ht)
    {
        for (int i = 0; i < h.length; i++) {
            if (h[i] < ht[i]) {
                return false;
            }
        }

        return true;
    }
}

package string;

/**
 * Implement strStr().
 * 
 * Returns a pointer to the first occurrence of needle in haystack, or null if
 * needle is not part of haystack.
 * 
 * [Difficulty] - Medium 
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/implement-strstr/}
 *
 */
public class dp_kmp {
    public String strStrNaive(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();

        for (int i = 0; i <= m - n; ++i) {
            int j = 0;

            for (; j < n; ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == n) {
                return haystack.substring(i);
            }
        }

        return null;
    }

    /**
     * Every time a mismatch occurs, all matched characters where started from current
     * i will be ignored and we let j start afresh from 0 again. We do a lot of unnecessary
     * comparing.
     * 
     * So we can do some preprocessing to let the index backtrack to the closest (in terms of j)
     * position k such that:
     * 
     *      p[0, ..., k] == p[j - k, ... , i],
     * 
     * So at each position i, from 0 to n -1, inclusively, we compute R(i, i - 1) for i and
     * fill in the table.
     * 
     *      R(i, k) = { R(i, R(k))       if p[R(k)] != p[i],
     *                  k + 1            otherwise
     *                }
     * 
     */
    public String strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int[] overlay = preprocess(needle, n);

        for (int i = 0; i <= m - n; ++i) {
            int j = 0;

            for (; j < n; ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == n) {
                return haystack.substring(i);
            } else if (j > 0) {
                i = i + j - overlay[j - 1] - 1;
            }
        }

        return null;
    }

    private int[] preprocess(String needle, int n) {
        int[] overlay = new int[n];

        for (int i = 1; i < n; i++) {
            int j = overlay[i - 1];

            while (j > 0 && needle.charAt(j) != needle.charAt(i)) {
                j = overlay[j - 1];
            }

            if (needle.charAt(j) == needle.charAt(i)) {
                overlay[i] = overlay[i - 1] + 1;
            }
        }

        return overlay;
    }
}
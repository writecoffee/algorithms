package window;

public class tp_longest_substring_without_repeating_characters {
    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int gMax = 0;
        int n = s.length();

        int i = 0, j = 0;
        while (i < n && j + gMax < n) {
            if (exist[s.charAt(i)]) {
                exist[s.charAt(j++)] = false;
            } else {
                exist[s.charAt(i++)] = true;
            }

            gMax = Math.max(gMax, i - j);
        }

        return gMax;
    }
}
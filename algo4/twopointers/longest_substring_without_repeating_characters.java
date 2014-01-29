public class longest_substring_without_repeating_characters {

    public static int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int result = 0;
        int start = 0;
        int end = 0;
        int n = s.length();

        while (end < n && start + result < n) {
            if (!exist[s.charAt(end)]) {
                exist[s.charAt(end++)] = true;
            } else {
                exist[s.charAt(start++)] = false;
            }

            result = Math.max(end - start, result);
        }

        return result;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcbc");
    }
}
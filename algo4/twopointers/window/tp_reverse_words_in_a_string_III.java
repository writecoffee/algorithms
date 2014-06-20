package window;

/**
 * Given an input string, reverse the string word by WORD.
 * 
 * For example,
 * 
 * "the sky is blue" => "blue is sky the"
 * "  a" => "a"
 * "K" => "K"
 * "ab" => "ab"
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain https://oj.leetcode.com/problems/reverse-words-in-a-string/}
 * 
 */
public class tp_reverse_words_in_a_string_III {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), j = -1;

        for (int i = n - 1; i >= 0; --i) {
            char c = s.charAt(i);

            if (c == ' ' && j >= 0) {
                addWord(sb, s, i + 1, j);
                j = -1;
            } else if (c != ' ' && j < 0) {
                j = i;
            }
        }

        if (j >= 0) {
            addWord(sb, s, 0, j);
        }

        return sb.toString();
    }

    private void addWord(StringBuilder sb, String s, int i, int j) {
        if (sb.length() > 0) {
            sb.append(' ');
        }

        while (i <= j) {
            sb.append(s.charAt(i++));
        }
    }
}
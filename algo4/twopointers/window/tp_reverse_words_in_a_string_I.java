package window;

/**
 * Given an input string, reverse the string word by CHARACTER.
 * 
 * For example,
 * 
 * "the sky is blue" => "eht yks si eulb"
 * "  a" => "a"
 * "K" => "K"
 * "ab" => "ba"
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, variation of {@linkplain https://oj.leetcode.com/problems/reverse-words-in-a-string/}
 * 
 */
public class tp_reverse_words_in_a_string_I {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length(), j = -1;

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);

            if (c == ' ' && j >= 0) {
                addReversedWord(sb, s, j, i - 1);
                j = -1;
            } else if (c != ' ' && j < 0) {
                j = i;
            }
        }

        if (j >= 0) {
            addReversedWord(sb, s, j, n - 1);
        }

        return sb.toString();
    }

    private void addReversedWord(StringBuilder sb, String s, int j, int i) {
        if (sb.length() > 0) {
            sb.append(' ');
        }

        while (i >= j) {
            sb.append(s.charAt(i--));
        }
    }
}
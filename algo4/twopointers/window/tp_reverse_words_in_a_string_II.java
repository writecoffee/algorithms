package window;

/**
 * Given an input string, reverse the string word by WORD and CHARACTER.
 *
 * For example,
 *
 * "the sky is blue" => "eulb si yks eht"
 * "  a" => "a"
 * "K         " => "K"
 * "ab" => "ba"
 *
 * [Difficulty] - Medium
 * [Source]     - facebook interview,
 *                variation of {@linkplain https://oj.leetcode.com/problems/reverse-words-in-a-string/}
 *
 */
public class tp_reverse_words_in_a_string_II
{
    public String reverseWords(String s)
    {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = n - 1; i >= 0; --i) {
            char c = s.charAt(i);

            if (c != ' ' && sb.length() > 0 && i < n - 1 && s.charAt(i + 1) == ' ') {
                sb.append(' ');
                sb.append(c);
            } else if (c != ' ') {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}

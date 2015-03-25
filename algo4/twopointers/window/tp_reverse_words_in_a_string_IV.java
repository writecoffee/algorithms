package window;

/**
 * Given an input string, reverse the string word by word. A word is
 * defined as a sequence of non-space characters.
 *
 * The input string does not contain leading or trailing spaces and
 * the words are always separated by a single space.
 *
 * For example,
 *
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 *
 * [Difficulty] - Medium
 * [Source]     - facebook interview,
 *                {@linkplain https://oj.leetcode.com/problems/reverse-words-in-a-string-ii/}
 *
 */
public class tp_reverse_words_in_a_string_IV
{
    public void reverseWords(char[] s)
    {
        int n = s.length;

        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            swap(s, i, j);
        }

        int i = -1;
        for (int j = 1; j < n; j++) {
            if (s[j] == ' ') {
                reverse(s, i + 1, j - 1);
                i = j;
            }
        }

        reverse(s, i + 1, n - 1);
    }

    private void reverse(char[] s, int i, int j)
    {
        for (; i < j; i++, j--) {
            swap(s, i, j);
        }
    }

    private void swap(char[] s, int i, int j)
    {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}

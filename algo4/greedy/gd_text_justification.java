import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of words and a length L, format the text such that each line has exactly
 * L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can
 * in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If the number of
 * spaces on a line do not divide evenly between words, the empty slots on the left will be
 * assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between
 * words.
 * 
 * For example,
 * 
 *    words: ["This", "is", "an", "example", "of", "text", "justification."]
 *    L: 16.
 * 
 *    Return the formatted lines as:
 * 
 *    [
 *       "This    is    an",
 *       "example  of text",
 *       "justification.  "
 *    ]
 * 
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * Corner Cases:
 * 
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/text-justification/}
 * 
 */
public class gd_text_justification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> result = new ArrayList<String>();
        int i = 0, m = words.length;

        while (i < m) {
            int n = words[i].length(), next = i + 1;

            while (next < m && n + words[next].length() + (next - i) <= L) {
                n += words[next++].length();
            }

            StringBuilder sb = new StringBuilder();
            sb.append(words[i]);

            boolean isLastLine = (next == m);
            boolean oneWord = (next == i + 1);

            int average = isLastLine || oneWord ? 1 : (L - n) / (next - i - 1);
            int extra = isLastLine || oneWord ? 0 : (L - n) % (next - i - 1);

            for (int j = i + 1; j < next; ++j, --extra) {
                sb.append(fillChar(extra > 0 ? average + 1 : average, ' '));
                sb.append(words[j]);
            }

            result.add(sb.append(fillChar(L - sb.length(), ' ')).toString());
            i = next;
        }

        return result;
    }

    private String fillChar(int count, char c) {
        char[] array = new char[count];
        Arrays.fill(array, c);
        return new String(array);
    }
}
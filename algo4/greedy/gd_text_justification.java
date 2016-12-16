import java.util.ArrayList;
import java.util.List;

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
public class gd_text_justification
{
    public List<String> fullJustify(String[] input, int maxWidth)
    {
        int cLen = 0;
        List<String> result = new ArrayList<>();
        List<String> words = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            String w = input[i];

            if (cLen == 0) {
                words.add(w);
                cLen += w.length();
            } else if (w.length() + 1 + cLen <= maxWidth) {
                words.add(w);
                /*
                 * Conservatively assuming putting single space as delimiter.
                 */
                cLen += 1 + w.length();
            } else {
                result.add(toLine(words, cLen, maxWidth, false));
                words.clear();
                cLen = 0;
                i--;
            }
        }

        if (!words.isEmpty()) {
            result.add(toLine(words, cLen, maxWidth, true));
        }

        return result;
    }

    private String toLine(List<String> words, int cLen, int maxWidth, boolean isLastLine)
    {
        StringBuilder sb = new StringBuilder();

        if (isLastLine) {
            sb.append(words.get(0));
            for (int i = 1; i < words.size(); i++) {
                sb.append(' ').append(words.get(i));
            }

            sb.append(getSpaces(maxWidth - cLen));

        /*
         * The only case we need to add spaces at the front of the line.
         */
        } else if (words.size() == 1) {
            sb.append(words.get(0))
              .append(getSpaces(maxWidth - cLen));
        } else {
            int spaceEachGap = (maxWidth - (cLen - words.size() + 1)) / (words.size() - 1);
            int spaceExtra = (maxWidth - (cLen - words.size() + 1)) % (words.size() - 1);

            sb.append(words.get(0));

            for (int i = 1; i < words.size(); i++) {
                sb.append(getSpaces(spaceEachGap + (spaceExtra > 0 ? 1 : 0)));
                spaceExtra--;
                sb.append(words.get(i));
            }
        }

        return sb.toString();
    }

    private String getSpaces(int count)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }
}

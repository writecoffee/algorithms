import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Example:
 *
 * Given word = "word", return the following list (order does not matter):
 *
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1",
 * "w1r1", "1o2", "2r1", "3d", "w3", "4"] Show Company Tags
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/generalized-abbreviation/}
 *
 */
public class dfs_generalized_abbreviation
{
    public List<String> generateAbbreviations(String word)
    {
        List<String> result = new ArrayList<>();
        int n = word.length();
        explore(0, n, word, result, new StringBuilder(), false);
        return new ArrayList<String>(result);
    }

    private void explore(int i, int n, String word, List<String> result, StringBuilder path, boolean isPreDigit)
    {
        if (i == n) {
            result.add(path.toString());
            return;
        }

        path.append(word.substring(i, i + 1));
        explore(i + 1, n, word, result, path, false);
        path.delete(path.length() - 1, path.length());

        if (!isPreDigit) {
            return;
        }

        for (int k = 1; i + k <= n; k++) {
            int kLength = Integer.toString(k).length();
            path.append(k);
            explore(i + k, n, word, result, path, true);
            path.delete(path.length() - kLength, path.length());
        }
    }
}

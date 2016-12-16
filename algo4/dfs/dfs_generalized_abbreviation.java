import java.util.ArrayList;
import java.util.BitSet;
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
        explore(0, n, word, result, new BitSet());
        return result;
    }

    private void explore(int i, int n, String word, List<String> result, BitSet bitSet)
    {
        if (i == n) {
            result.add(convert(bitSet, word, n));
            return;
        }

        bitSet.set(i);
        explore(i + 1, n, word, result, bitSet);
        bitSet.clear(i);
        explore(i + 1, n, word, result, bitSet);
    }

    private String convert(BitSet bitSet, String word, int n)
    {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ) {

            int start = i;

            while (i < n && bitSet.get(i)) {
                i++;
            }

            int count = i - start;
            if (count > 0) {
                sb.append(count);
            } else {
                sb.append(word.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }
}

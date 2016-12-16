import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to
 * identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that
 * occur more than once in a DNA molecule.
 *
 * For example,
 *
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 *
 * Return:
 *
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/repeated-dna-sequences/}
 * [Difficulty] - Medium
 *
 */
public class bit_repeated_dna_sequence
{
    public List<String> findRepeatedDnaSequences(String s)
    {
        List<String> result = new ArrayList<>();
        Map<Integer, Integer> h = new HashMap<>();
        int[] ctable = new int['Z'];
        ctable['A'] = 0;
        ctable['C'] = 1;
        ctable['T'] = 2;
        ctable['G'] = 3;

        int n = s.length();
        int mask = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            mask = ((mask << 2) | ctable[c]) & 0xfffff;

            if (i < 9) {
                continue;
            }

            Integer count = h.get(mask);
            if (count == null) {
                count = 0;
            }
            count++;

            if (count == 2) {
                result.add(s.substring(i - 9, i + 1));
            }

            h.put(mask, count);
        }

        return result;
    }
}

package bitvector;

import java.util.ArrayList;
import java.util.List;

public class bit_repeated_dna_sequence
{
    public List<String> findRepeatedDnaSequences(String s)
    {
        List<String> result = new ArrayList<String>();

        int buckets = 1 << 16,
            n = s.length(),
            c = 0;

        if (n <= 10) {
            return result;
        }

        int[] dup = new int[buckets],
              added = new int[buckets],
              table = new int['Z'];

        table['A'] = 0;
        table['C'] = 1;
        table['T'] = 2;
        table['G'] = 3;

        for (int i = 0; i < 10; i++) {
            c = ((c << 2) | table[s.charAt(i)]) & 0xfffff;
        }

        dup[c / 32] = 1 << (c % 32);

        for (int i = 1; i <= n - 10; i++) {
            c = ((c << 2) | table[s.charAt(i + 9)]) & 0xfffff;

            int b = c / 32,
                bits = 1 << (c % 32);

            if ((dup[b] & bits) != 0) {
                if ((added[b] & bits) == 0) {
                    result.add(s.substring(i, i + 10));
                    added[b] |= bits;
                }
            }

            dup[b] |= bits;
        }

        return result;
    }
}

package memorization_search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * From a dictionary T, each time given a word from last iteration (start off from any pick of T),
 * if removing one character from the word could form a new word out of T, then you can continue
 * forming the chain.
 *
 * Calculate the longest chain you can form out of T.
 *
 * [Difficulty] - Medium
 * [Source]     - OA
 *
 */
public class dp_ms_string_chain
{
    static int longest_chain(String[] w)
    {
        Set<String> remainingWordSet = new HashSet<>(Arrays.asList(w));
        Map<String, Integer> hLen = new HashMap<>();
        int[] result = new int[] { 0 };

        for (String word : w) {
            remainingWordSet.remove(word);
            explore(remainingWordSet, word, result, 0, hLen);
            remainingWordSet.add(word);
        }

        return result[0];
    }

    private static void explore(Set<String> remainingWordSet, String word, int[] result, int chainLength, Map<String, Integer> hLen)
    {
        int cLen = word.length();
        int cMaxLen = 1;

        for (int i = 0; i < cLen; i++) {
            String target = word.substring(0, i) + word.substring(i + 1, cLen);

            Integer temptResult = hLen.get(target);
            if (temptResult != null) {
                cMaxLen = Math.max(cMaxLen, 1 + temptResult);
                continue;
            }

            if (remainingWordSet.contains(target)) {
                remainingWordSet.remove(target);
                explore(remainingWordSet, target, result, chainLength + 1, hLen);
                remainingWordSet.add(target);
                cMaxLen = Math.max(cMaxLen, 1 + hLen.get(target));
            }
        }

        hLen.put(word, cMaxLen);
        result[0] = Math.max(chainLength + cMaxLen, result[0]);
    }

    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _w_size = 0;
        _w_size = Integer.parseInt(in.nextLine());
        String[] _w = new String[_w_size];
        String _w_item;
        for (int _w_i = 0; _w_i < _w_size; _w_i++) {
            try {
                _w_item = in.nextLine();
            } catch (Exception e) {
                _w_item = null;
            }
            _w[_w_i] = _w_item;
        }

        res = longest_chain(_w);
        System.out.println(res);
        bw.write(String.valueOf(res));
        bw.newLine();

        in.close();
        bw.close();
    }
}

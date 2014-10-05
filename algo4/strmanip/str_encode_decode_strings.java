import java.util.ArrayList;
import java.util.List;


/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then
 * sent over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 *
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 *
 * So Machine 1 does:
 *
 * string encoded_string = encode(strs);
 *
 * and Machine 2 does:
 *
 * vector<string> strs2 = decode(encoded_string);
 *
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * Note:
 *
 * 1. The string may contain any possible characters out of 256 valid ascii characters.
 *    Your algorithm should be generalized enough to work on any possible characters.
 *
 * 2. Do not use class member/global/static variables to store states. Your encode and
 *    decode algorithms should be stateless.
 *
 * 3. Do not rely on any library method such as eval or serialize methods. You should
 *    implement your own encode/decode algorithm.
 *
 * [Source]         - {@linkplain https://leetcode.com/problems/encode-and-decode-strings/}
 * [Difficulty]     - Medium
 * [Tediousness]    - High
 *
 */
public class str_encode_decode_strings
{
    public String encode(List<String> strs)
    {
        StringBuilder sb = new StringBuilder();

        sb.append(strs.size() + "#");

        for (String s : strs) {
            sb.append(s.length() + "#");
        }

        for (String s :strs) {
            sb.append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s)
    {
        List<Integer> strLens = new ArrayList<>();
        int lastDelim = s.indexOf("#");
        int size = Integer.parseInt(s.substring(0, lastDelim));

        for (int i = 0; i < size; i++) {
            int nextDelim = s.indexOf('#', lastDelim + 1);
            strLens.add(Integer.parseInt(s.substring(lastDelim + 1, nextDelim)));
            lastDelim = nextDelim;
        }

        lastDelim++;
        List<String> result = new ArrayList<>();

        for (int len : strLens) {
            int start = lastDelim;
            lastDelim += len;
            result.add(s.substring(start, lastDelim));
        }

        return result;
    }
}

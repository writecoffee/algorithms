/**
 * Given a string, compress it when more than 3 consecutive characters in the string
 * are the same.
 * 
 * For example: 
 * 
 * Given "abccccc", it should be compressed into "ab5xc".
 * 
 * The decoder can restore the compressed string given the rule: NUMBER x CHARACTER.
 * So if the original string contains number followed by 'x' and then any character,
 * it will be de-compressed by the decoder mistakenly. Figure out a way to fix it.
 * 
 * [Difficulty] - Hard
 * [Source]     - google interview
 *
 */
public class stm_compress_string {
    public String compress(String s) {
        int n = s.length(), l = 0;
        StringBuilder sb = new StringBuilder();

        for (int r = 1; r < n; ++r) {
            char p = s.charAt(r - 1), c = s.charAt(r);

            if (p != c) {
                appendString(s, l, r, sb);
                l = r;
            }
        }

        appendString(s, l, n, sb);
        return sb.toString();
    }

    private void appendString(String s, int l, int r, StringBuilder sb) {
        int len = r - l;

        if (len > 3) {
            sb.append(len).append('x').append(s.charAt(l));
        } else if (len == 1 && Character.isDigit(s.charAt(l))) {
            sb.append("1x").append(s.charAt(l));
        } else {
            sb.append(s.substring(l, r));
        }
    }
}
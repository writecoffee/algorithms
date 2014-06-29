/**
 * Multiply two strings, considering negative numbers, 0 as well.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.itint5.com/oj/#29}
 *
 */
public class math_multiply_strings_II {
    public String multiply(String a, String b) {
        int m = a.length(), n = b.length();
        boolean isNeg = (a.startsWith("-") && !b.startsWith("-")) || (!a.startsWith("-") && b.startsWith("-"));

        if (a.startsWith("-")) {
            m--;
            a = a.substring(1);
        }

        if (b.startsWith("-")) {
            n--;
            b = b.substring(1);
        }

        int[] result = new int[m + n];

        for (int i = 0; i < n; ++i) {
            int carry = 0;
            int bVal = (int) (b.charAt(n - 1 - i) - '0');

            for (int j = 0; j < m; ++j) {
                int aVal = (int) (a.charAt(m - 1 - j) - '0');
                int t = aVal * bVal + carry + result[m + n - 1 - i - j];

                result[m + n - 1 - i - j] = t % 10;
                carry = t / 10;
            }

            result[m + n - 1 - i - m] += carry;
        }

        int i = 0;
        while (i < m + n && result[i] == 0) {
            i++;
        }

        return convert(isNeg, result, i, m + n);
    }

    private String convert(boolean isNeg, int[] result, int start, int end) {
        StringBuilder sb = new StringBuilder();

        if (start == end) {
            return "0";
        } else if (isNeg) {
            sb.append('-');
        }

        for (int i = start; i < end; ++i) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
}
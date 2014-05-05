public class multiply_strings_with_negative {
    public String multiply(String a, String b) {
        int m = a.length(), n = b.length();

        boolean isNeg = (a.startsWith("-") && !b.startsWith("-")) || (!a.startsWith("-") && b.startsWith("-"));
        boolean isZero = a.equals("0") || b.equals("0");

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

        return convert(isZero, isNeg, result, i, m + n);
    }

    private String convert(boolean isZero, boolean isNeg, int[] result, int start, int end) {
        StringBuilder sb = new StringBuilder();

        if (isZero) {
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
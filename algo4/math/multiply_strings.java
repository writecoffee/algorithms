public class multiply_strings {
    public String multiply(String a, String b) {
        int m = a.length(), n = b.length();
        boolean isZero = a.equals("0") || b.equals("0");
        int[] result = new int[m + n];

        for (int i = 0; i < n; ++i) {
            int carry = 0;
            int bVal = b.charAt(n - 1 - i) - '0';

            for (int j = 0; j < m; ++j) {
                int aVal = a.charAt(m - 1 - j) - '0';
                int t = aVal * bVal + carry + result[m + n - 1 - i - j];
                result[m + n - 1 - i - j] = t % 10;
                carry = t / 10;
            }

            result[m + n - 1 - i - m] += carry;
        }

        int i = 0;
        while (i < m + n && result[i] == 0) {
            ++i;
        }

        return convert(isZero, result, i, m + n);
    }

    private String convert(boolean isZero, int[] result, int start, int end) {
        if (isZero) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; ++i) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
}
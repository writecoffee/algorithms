import java.util.Arrays;

public class multiply_strings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n + 1];
        int k = result.length;

        for (int i = 0, offset = 0; i < n; ++i, ++offset) {
            int carry = 0;
            int j = 0;

            for (; j < m; ++j) {
                int a = num1.charAt(m - 1 - j) - '0';
                int b = num2.charAt(n - 1 - i) - '0';

                int product = a * b + carry + result[k - 1 - j - offset];

                result[k - 1 - j - offset] = (product % 10);
                carry = product / 10;
            }

            result[k - 1 - j - offset] += carry;
        }

        int i = 0;
        while (i < k - 1 && result[i] == 0) {
            ++i;
        }

        return toString(Arrays.copyOfRange(result, i, result.length));
    }

    private String toString(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; ++i) {
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
public class multiply_strings {

    public static String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n + m; i++) {
            result.append('0');
        }

        for (int i = n - 1; i >= 0; --i) {
            int carry = 0;
            for (int j = m - 1; j >= 0; --j) {
                int sum = carry + result.charAt(i + j + 1) - '0' + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result.setCharAt(i + j + 1, (char) (sum % 10 + '0'));
                carry = sum / 10;
            }

            result.setCharAt(i, (char) (result.charAt(i) + carry));
        }

        while (result.length() > 1 && result.charAt(0) == '0') {
            result.delete(0, 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("99", "977"));
    }
}
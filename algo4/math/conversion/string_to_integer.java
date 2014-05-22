package conversion;

public class string_to_integer {
    public int atoi(String str) {
        int n = str.length();
        long result = 0;
        int sign = 1;
        int i = 0;

        if (n == 0) {
            return 0;
        }

        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (str.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }

        for (; i < n && Character.isDigit(str.charAt(i)); ++i) {
            result = result * 10 + (int) (str.charAt(i) - '0');
        }

        result *= sign;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}
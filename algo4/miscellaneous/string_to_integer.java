
public class string_to_integer {

    public int atoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int i = 0;
        for (; i < str.length(); ++i) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }
        if (i == str.length()) {
            throw new IllegalArgumentException();
        }

        boolean isPositive = true;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            isPositive = str.charAt(i) == '+';
            i++;
        }

        if (i == str.length()) {
            throw new IllegalArgumentException();
        }

        long result = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        result = isPositive ? result : -result;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {

    }
}
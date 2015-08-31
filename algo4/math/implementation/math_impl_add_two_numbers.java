package implementation;

public class math_impl_add_two_numbers {
    public String add(String a, String b) {
        if (a.length() < b.length()) {
            return add(b, a);
        }

        int m = a.length(), n = b.length();
        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = m - 1, j = n - 1; j >= 0; --i, --j) {
            int t = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            sb.append(t % 10);
            carry = t / 10;
        }

        for (int i = m - n - 1; i >= 0; --i) {
            int t = (a.charAt(i) - '0') + carry;
            sb.append(t % 10);
            carry = t / 10;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
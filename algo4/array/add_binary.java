public class add_binary {
    public String addBinary(String a, String b) {
        int maxlen = Math.max(a.length(), b.length());
        char[] result = new char[maxlen];
        StringBuilder sb = new StringBuilder();

        int c = 0;
        for (int i = 0; i < maxlen; i++) {
            int ad = (i > a.length() - 1) ? 0 : a.charAt(a.length() - 1 - i) - '0';
            int bd = (i > b.length() - 1) ? 0 : b.charAt(b.length() - 1 - i) - '0';
            int t = ad + bd + c;

            result[result.length - 1 - i] = (char) (t % 2 + '0');
            c = t / 2;
        }

        return c > 0 ? sb.append('1').append(new String(result)).toString() : new String(result);
    }

    public String addBinarySimple(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int c = 0;

        while (i >= 0 && j >= 0) {
            int t = (int) (a.charAt(i) - '0') + (int) (b.charAt(j) - '0') + c;
            c = t / 2;
            sb.append(t % 2);
            i--;
            j--;
        }

        while (i >= 0) {
            int t = (int) (a.charAt(i) - '0') + c;
            c = t / 2;
            sb.append(t % 2);
            i--;
        }

        while (j >= 0) {
            int t = (int) (b.charAt(j) - '0') + c;
            c = t / 2;
            sb.append(t % 2);
            j--;
        }

        if (c > 0) {
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
public class replace_space_with_multiple_symbol {
    static String escapeSpace(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; --i) {
            if (str.charAt(i) == ' ') {
                sb.append("02%");
            } else {
                sb.append(str.charAt(i));
            }
        }

        return sb.reverse().toString();
    }
}
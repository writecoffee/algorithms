public class separate_characters_and_numbers {
    public static String separate(String s) {
        int i = 0;
        char[] cstring = s.toCharArray();

        while (i < s.length()) {
            if (i > 0 && Character.isDigit(cstring[i - 1])) {
                swap(cstring, i - 1, i);
                i--;
                continue;
            } else if (Character.isDigit(cstring[i])) {
                int j = i + 1;
                while (j < s.length() && Character.isDigit(cstring[j])) {
                    ++j;
                }

                if (j == s.length()) {
                    break;
                }

                swap(cstring, i, j);
                i = j;
            } else {
                ++i;
            }
        }

        return new String(cstring);
    }

    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(separate("a1b2c3d4"));
        System.out.println(separate("a1b2c3d4efg59h"));
    }
}
public class reverse_words_in_a_string {
    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        int i = s.length() - 1;
        boolean touchedSpace = true;

        while (i >= 0) {
            if (s.charAt(i) == ' ' && touchedSpace) {

            } else if (s.charAt(i) == ' ') {
                word.append(' ');
                result.append(word.reverse());
                word = new StringBuilder();
                touchedSpace = true;
            } else {
                word.append(s.charAt(i));
                touchedSpace = false;
            }

            i--;
        }

        if (word.length() > 0) {
            word.append(' ');
            result.append(word.reverse());
        }

        return result.length() == 0 ? "" : result.substring(1).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" "));
        System.out.println(reverseWords(" a b cd  "));
        System.out.println(reverseWords("a"));
    }
}
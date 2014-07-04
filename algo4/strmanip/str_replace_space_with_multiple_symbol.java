/**
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has
 * sufficient space at the end of the string to hold the additional characters, and that you are
 * given the "true" length of the string. (Note: if implementing in Java, please use a character
 * array so that you can perform this operation in place.)
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain CC150-1.4}
 * 
 */
public class str_replace_space_with_multiple_symbol {
    public String replaceSpace(String str) {
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
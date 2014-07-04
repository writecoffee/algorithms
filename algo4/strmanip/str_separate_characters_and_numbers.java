/**
 * The input string contains letters and digits only, separate them
 * in place such that all letters appear on the right, all digits 
 * appear on the left.
 * 
 * [Difficulty] - Easy
 * [Source]     - microsoft interview
 *
 */
public class str_separate_characters_and_numbers {
    public String separate(char[] s) {
        int n = s.length;
        int l = 0, r = n - 1;

        while (l < r) {
            while (l < r && Character.isDigit(s[l])) {
                l++;
            }

            while (l < r && Character.isLetter(s[r])) {
                r--;
            }

            swap(s, l, r);
        }

        return new String(s);
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
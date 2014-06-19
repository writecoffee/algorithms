/**
 * Given two string, if string a is bigger than string b in alphabetical order,
 * return any arbitrary positive number; if a equals b, return 0, otherwise,
 * return any arbitrary negative number.
 * 
 * [Difficulty] - Easy
 * [Source]     - facebook interview
 *
 */
public class compare_two_string {
    public int compareTo(String a, String b) {
        int m = a.length(), n = b.length(), i = 0;
        a = a + '\0';
        b = b + '\0';

        for (; i < m && i < n; ++i) {
            if (a.charAt(i) - b.charAt(i) != 0) {
                return a.charAt(i) - b.charAt(i);
            }
        }

        return a.charAt(i) - b.charAt(i);
    }
}
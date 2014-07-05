/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * 
 * string convert(string text, int nRows);
 * 
 * For example:
 * 
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/zigzag-conversion/}
 *
 */
public class str_zigzag_conversion {
    public String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }

        int n = s.length(), stride = 2 * (nRows - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nRows; ++i) {
            for (int j = 0; true; j += stride) {
                if (i > 0 && i < nRows - 1 && j - i >= 0 && j - i < n) {
                    sb.append(s.charAt(j - i));
                }

                if (j + i < n) {
                    sb.append(s.charAt(j + i));
                } else {
                    break;
                }
            }
        }

        return sb.toString();
    }
}
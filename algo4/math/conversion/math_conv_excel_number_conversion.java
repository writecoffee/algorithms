package conversion;

/**
 * In excel, the row and column are represented in A~Z.
 *
 * A, B, C, D, ...,  Z, AA, AB, ..., AZ, BA, BB, ...
 *
 * are used to represent
 *
 * 1, 2, 3, 4, ..., 26, 27, 28, ..., 52, 53, 54, ...
 *
 * Implement the decimal-to-excel conversion and excel-to-decimal conversion respectively.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.itint5.com/oj/#23}
 *                {@linkplain https://leetcode.com/problems/excel-sheet-column-title/}
 *
 */
public class math_conv_excel_number_conversion
{
    public String decToExcel(int n)
    {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }

        return sb.reverse().toString();
    }

    public int excelToDec(String excelNum)
    {
        int result = 0, n = excelNum.length();

        for (int i = 0; i < n; ++i) {
            result = result * 26 + (excelNum.charAt(i) - 'A' + 1);
        }

        return result;
    }
}

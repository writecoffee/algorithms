public class excel_number_conversion {
    public String decToExcel(int decNum) {
        StringBuilder sb = new StringBuilder();
        while (decNum > 0) {
            int c = (decNum - 1) % 26;
            decNum = (decNum - 1) / 26;
            sb.append((char) ('A' + c));
        }

        return sb.reverse().toString();
    }

    public int excelToDec(String excelNum) {
        int result = 0;
        int n = excelNum.length();
        for (int i = 0; i < n; ++i) {
            result = result * 26 + (excelNum.charAt(i) - 'A' + 1);
        }

        return result;
    }
}
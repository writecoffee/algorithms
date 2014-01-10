
public class decode_ways {
    
    static int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }

        int N = s.length();
        int[] tableDecoded = new int[N + 1];
        tableDecoded[0] = 1;
        tableDecoded[1] = 1;

        for (int i = 1; i < N; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2') {
                    return 0;
                }

                tableDecoded[i + 1] = tableDecoded[i - 1];
            } else {
                int numDecoded = s.charAt(i) - '0' + (s.charAt(i - 1) - '0') * 10;
                if (numDecoded >= 11 && numDecoded <= 26) {
                    tableDecoded[i + 1] = tableDecoded[i] + tableDecoded[i - 1];
                } else {
                    tableDecoded[i + 1] = tableDecoded[i];
                }
            }
        }

        return tableDecoded[N];
    }
    
    public static void main(String[] args) {
        numDecodings("12");
    }
}
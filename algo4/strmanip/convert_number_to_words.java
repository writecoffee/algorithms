import java.util.ArrayDeque;
import java.util.Deque;

public class convert_number_to_words {
    /**
     * No preceding zeros!
     */
    static String convertWords(String num) {
        int n = num.length();
        StringBuilder sb = new StringBuilder();

        String[] singleDigits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String[] twoDigits = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
        String[] tensMultiple = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
        String[] tensPower = { "", "thousand", "million", "billion" };

        Deque<String> result = new ArrayDeque<String>();
        for (int i = 0, j = 0; i < n; i += 3, j++) {
            result.addFirst(tensPower[j]);

            int validBits = n - i > 2 ? 3 : n - i;
            int l = n - i - 1;

            if (validBits >= 2) {
                if (num.charAt(l - 1) == '1') {
                    result.addFirst(twoDigits[num.charAt(l) - '0']);
                } else if (num.charAt(l) == '0') {
                    result.addFirst(tensMultiple[num.charAt(l - 1) - '0']);
                } else {
                    result.addFirst(singleDigits[num.charAt(l) - '0']);
                    result.addFirst(tensMultiple[num.charAt(l - 1) - '0']);
                }
            } else if (validBits == 1) {
                result.addFirst(singleDigits[num.charAt(l) - '0']);
            }

            if (validBits == 3 && num.charAt(l - 2) != '0') {
                int digit = num.charAt(l - 2) - '0';
                result.addFirst("hundred");
                result.addFirst(singleDigits[digit]);
                validBits--;
            }
        }

        for (String s : result) {
            sb.append(' ');
            sb.append(s);
        }

        return sb.subSequence(1, sb.length()).toString();
    }

    public static void main(String[] args) {
        System.out.println(convertWords("2220539"));
        System.out.println(convertWords("0"));
        System.out.println(convertWords("1000"));
    }
}
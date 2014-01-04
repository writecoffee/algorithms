
public class valid_number {

    /**
     * Cases need to be discussed:
     * 
     * Using e is only a shorthand to simplify the writing of a number, and can
     * be followed only be a (signed) integer. It does not involve any
     * (mathematical) computation, only shifting the decimal mark.
     * 
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        int N = s.length();
        boolean hasDot = false;
        boolean hasCharE = false;
        boolean hasNum = false;

        if (N == 0) {
            return false;
        }

        int start = 0;
        while (start < N) {
            if (s.charAt(start) == ' ') {
                start++;
            } else {
                break;
            }
        }

        if (start == N) {
            return false;
        }

        int end = N - 1;
        while (end > start) {
            if (s.charAt(end) == ' ') {
                end--;
            } else {
                break;
            }
        }

        if (s.charAt(start) == '+' || s.charAt(start) == '-') {
            start++;
        } else if (s.charAt(start) == 'e') {
            return false;
        }

        for (int i = start; i <= end; i++) {
            if (s.charAt(i) == '.') {
                if (hasDot) {
                    return false;
                } else {
                    hasDot = true;
                }
            } else if (s.charAt(i) == 'e') {
                /**
                 * Invalid cases: e34, 34ee, 34e+, 9e, and etc.
                 * 
                 */
                if (!hasNum
                        || hasCharE
                        || i == end
                        || (i == end - 1 && (s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-'))) {
                    return false;
                } else {
                    /**
                     *  After "e" we cannot apply "." anymore.
                     */
                    if (s.charAt(i + 1) == '-' || s.charAt(i + 1) == '+') {
                        i++;
                    }

                    hasCharE = true;
                    hasDot = true;
                }
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                hasNum = true;
            } else {
                return false;
            }
        }

        return hasNum;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0e"));
        System.out.println(isNumber("."));
        System.out.println(isNumber(" 0"));
    }
}

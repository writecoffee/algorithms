public class plus_one {
    public int[] plusOne(int[] digits) {
        int i = 0;
        while (i < digits.length && digits[digits.length - 1 - i] == 9) {
            i++;
        }

        int[] result = digits;
        if (i == digits.length) {
            result = new int[digits.length + 1];
        }

        if (i > 0) {
            result[result.length - 1 - i]++;
            for (int j = result.length - i; j < result.length; j++) {
                result[j] = 0;
            }
        } else {
            result[result.length - 1]++;
        }

        return result;
    }
}
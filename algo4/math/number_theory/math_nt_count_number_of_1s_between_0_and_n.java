package number_theory;

/**
 * Write a method to count the number of 2s between 0 and n.
 * 
 * Sample input:
 * 
 *      2 => 1
 *      25 => 9
 *      1 => 0
 *      11 => 1
 * 
 * [Difficulty] - Hard
 * [Source]     - {@linkplain CC150-18.4}
 * 
 */
public class math_nt_count_number_of_1s_between_0_and_n {
    /**
     * The algorithm is to iterate through all digits in the number from right to left
     * and discuss how many times 2 can appear at the current position.
     * 
     * So when we sum all appearance of 2 for each position we can yield the result.
     * 
     */
    public int count2sInRange(int number) {
        String str = String.valueOf(number);
        int count = 0, n = str.length();

        for (int i = 0; i < n; i++) {
            count += count2sInRangeAtDigit(number, i, n);
        }

        return count;
    }

    private int count2sInRangeAtDigit(int number, int d, int n) {
        int s = (int) Math.pow(10, d);
        int l = number / (s * 10);
        int r = number % s;
        int digit = number / s % 10;

        if (digit == 2) {
            return l * s + r + 1;
        } else if (digit < 2) {
            return l * s;
        } else {
            return (l + 1) * s;
        }
    }
}

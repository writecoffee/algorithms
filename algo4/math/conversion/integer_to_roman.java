package conversion;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * https://oj.leetcode.com/problems/integer-to-roman/
 * 
 */
public class integer_to_roman {
    /**
     * We can apply some greedy heuristic here by subtracting the most significant Roman
     * digit from the input number. So we can create a table or array which ranges in
     * descending order, where we can map from index to Roman digit representation, and
     * from index to decimal digit representation.
     * 
     * Also there is special case where the left digit is smaller than the right digit
     * which will break the greedy heuristic when we are moving the index. So we also
     * need to add those special cases into our tables.
     * 
     */
    public String intToRoman(int num) {
        int[] ints = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] romans = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (num > 0) {
            if (num >= ints[i]) {
                num -= ints[i];
                sb.append(romans[i]);
            } else {
                ++i;
            }
        }

        return sb.toString();
    }
}
import java.util.ArrayList;

/**
 * The gray code is a binary numeral system where two successive values differ in only
 * one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 
 *    00 - 0
 *    01 - 1
 *    11 - 3
 *    10 - 2
 * 
 * Note:
 * 
 * For a given n, a gray code sequence is not uniquely defined.
 *
 * [Difficulty] - Easy
 * [Source]     - google interview, {@linkplain https://oj.leetcode.com/problems/gray-code/}
 * 
 */
public class bit_gray_code {
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);

        for (int i = 0; i < n; i++) {
            int bit = 1 << i;

            for (int j = result.size() - 1; j >= 0; j--) {
                result.add(result.get(j) | bit);
            }
        }

        return result;
    }
}
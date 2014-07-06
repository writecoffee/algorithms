import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * 
 * Return [1,3,3,1].
 * 
 * Note:
 * 
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/pascals-triangle-ii/}
 *
 */
public class pascal_triangle_II {
    public ArrayList<Integer> getRow(int k) {
        Integer[] arrays = new Integer[k + 1];
        Arrays.fill(arrays, 1);

        for (int i = 1; i <= k; ++i) {
            for (int j = i - 1; j >= 1; --j) {
                arrays[j] += arrays[j - 1];
            }
        }

        return new ArrayList<Integer>(Arrays.asList(arrays));
    }
}
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * 
 * For example, given numRows = 5,
 * 
 * Return
 * 
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/pascals-triangle/}
 *
 */
public class pascal_triangle_I {
    public ArrayList<ArrayList<Integer>> generate(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (n < 1) {
            return result;
        }

        ArrayList<Integer> pre = new ArrayList<Integer>(Arrays.asList(new Integer[] { 1 }));
        result.add(pre);

        for (int i = 1; i < n; ++i) {
            ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(new Integer[] { pre.get(0) }));
            int m = pre.size();

            for (int j = 1; j < m; ++j) {
                c.add(pre.get(j - 1) + pre.get(j));
            }

            c.add(pre.get(m - 1));
            pre = c;
            result.add(c);
        }

        return result;
    }
}
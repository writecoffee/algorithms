package gmin;

import java.util.ArrayList;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each
 * step you may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain http://oj.leetcode.com/problems/triangle/}
 * 
 */
public class dp_minimum_path_sum_in_triangle {
    public int minimumTotalInplace(ArrayList<ArrayList<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0; j < i + 1; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + 
                                       Math.min(triangle.get(i + 1).get(j),
                                                triangle.get(i + 1).get(j + 1)));
            }
        }

        return triangle.get(0).get(0);
    }

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[] dp = new int[n];

        for (int j = 0; j < n; ++j) {
            dp[j] = triangle.get(m - 1).get(j);
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = 0; j < triangle.get(i).size(); ++j) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }
}
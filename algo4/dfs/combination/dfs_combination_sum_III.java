package combination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 *
 * Output:
 *
 * [[1,2,4]]
 *
 * Example 2:
 *
 * Input: k = 3, n = 9
 *
 * Output:
 *
 * [[1,2,6], [1,3,5], [2,3,4]]
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/combination-sum-iii/}
 * [Difficulty] - Medium
 *
 */
public class dfs_combination_sum_III
{
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> result = new ArrayList<>();
        int[] candidates = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        explore(candidates, 0, k, n, new Stack<>(), 0, result);
        return result;
    }

    private void explore(int[] candidates, int iStart, int k, int n, Stack<Integer> path, int pathSum, List<List<Integer>> result)
    {
       if (path.size() == k && pathSum == n) {
           result.add(new ArrayList<>(path));
           return;
       }

       for (int i = iStart; i < candidates.length; i++) {
           int can = candidates[i];
           if (can + pathSum > n) {
               break;
           }

           path.push(can);
           explore(candidates, i + 1, k, n, path, pathSum + can, result);
           path.pop();
       }
    }
}

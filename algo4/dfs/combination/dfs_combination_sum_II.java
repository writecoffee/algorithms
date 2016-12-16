package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 *
 * EACH NUMBER IN C MAY ONLY BE USED ONCE IN THE COMBINATION.
 *
 * Note:
 *
 *     -- All numbers (including target) will be positive integers.
 *     -- Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *     -- The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 *
 * A solution set is:
 *
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/combination-sum/}
 *
 */
public class dfs_combination_sum_II
{
    public List<List<Integer>> combinationSum2(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        explore(candidates, 0, target, new Stack<>(), result, 0);
        return result;
    }

    private void explore(int[] candidates, int iStart, int target, Stack<Integer> stack, List<List<Integer>> result, int pathSum)
    {
        if (pathSum == target) {
            result.add(new ArrayList<>(stack));
            return;
        } else if (iStart == candidates.length) {
            return;
        }

        for (int i = iStart; i < candidates.length; i++) {
            int can = candidates[i];

            if (i > iStart && can == candidates[i - 1]) {
                continue;
            } else if (can + pathSum > target) {
                break;
            }

            stack.push(can);
            explore(candidates, i + 1, target, stack, result, pathSum + can);
            stack.pop();
        }
    }
}

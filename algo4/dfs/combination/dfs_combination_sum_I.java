package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T.
 *
 * THE SAME REPEATED NUMBER MAY BE CHOSEN FROM C UNLIMITED NUMBER OF TIMES.
 *
 * Note:
 *
 *    -- All numbers (including target) will be positive integers.
 *    -- Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 *    -- The solution set must not contain duplicate combinations.
 *
 * For example, given candidate set 2,3,6,7 and target 7,
 *
 * A solution set is:
 *
 * [7]
 * [2, 2, 3]
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/combination-sum/}
 *
 */
public class dfs_combination_sum_I
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);
        explore(candidates, 0, target, result, new Stack<>(), 0);

        return result;
    }

    private void explore(int[] candidates, int candidateStart, int target, List<List<Integer>> result, Stack<Integer> path, int pathSum)
    {
        if (pathSum == target) {
            result.add(new ArrayList<>(path));
            return;
        } else if (candidateStart == candidates.length) {
            return;
        }

        for (int i = candidateStart; i < candidates.length; i++) {
            int can = candidates[i];

            if (can + pathSum > target) {
                break;
            }

            path.push(can);
            explore(candidates, i, target, result, path, pathSum + can);
            path.pop();
        }
    }
}

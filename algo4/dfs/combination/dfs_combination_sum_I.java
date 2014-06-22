package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
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
public class dfs_combination_sum_I {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        explore(candidates, candidates.length, target, 0, new Stack<Integer>(), result);
        return result;
    }

    private void explore(int[] candidates, int n, int target, int start, Stack<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = start; i < n && target >= candidates[i]; ++i) {
            if (i == 0 || candidates[i] != candidates[i - 1]) {
                path.push(candidates[i]);
                explore(candidates, n, target - candidates[i], i, path, result);
                path.pop();
            }
        }
    }
}
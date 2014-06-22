package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
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
public class dfs_combination_sum_II {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
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

        for (int i = start; i < n && candidates[i] <= target; ++i) {
            if (i == start || candidates[i] != candidates[i - 1]) {
                path.push(candidates[i]);
                explore(candidates, n, target - candidates[i], i + 1, path, result);
                path.pop();
            }
        }
    }
}
package combination;

import java.util.ArrayList;
import java.util.Arrays;

public class combination_sum_elements_used_only_once {
    /**
     * Given a collection of candidate numbers (C) and a target number (T), 
     * find all unique combinations in C where the candidate numbers sums to T.
     * 
     * Each number in C may only be used once in the combination.
     * 
     * Note:
     * 
     *     # All numbers (including target) will be positive integers.
     *     # Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
     *     # The solution set must not contain duplicate combinations.
     * 
     */
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        explore(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void explore(int[] candidates, int target, int i, ArrayList<Integer> nxt, ArrayList<ArrayList<Integer>> result) {
        int n = candidates.length;

        if (target == 0) {
            result.add(new ArrayList<Integer>(nxt));
            return;
        }

        for (int j = i; j < n && candidates[j] <= target; ++j) {
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }

            nxt.add(candidates[j]);
            explore(candidates, target - candidates[j], j + 1, nxt, result);
            nxt.remove(nxt.size() - 1);
        }
    }
}
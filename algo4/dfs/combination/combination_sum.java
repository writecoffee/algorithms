package combination;

import java.util.ArrayList;
import java.util.Arrays;

public class combination_sum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(candidates);
        explore(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private void explore(int[] candidates, int target, int i, ArrayList<Integer> nxt, ArrayList<ArrayList<Integer>> result) {
        int n = candidates.length;

        if (target == 0) {
            result.add(new ArrayList<Integer>(nxt));
            return;
        }

        for (int j = i; j < n && target >= candidates[j]; j++) {
            nxt.add(candidates[j]);
            explore(candidates, target - candidates[j], j, nxt, result);
            nxt.remove(nxt.size() - 1);
        }
    }
}
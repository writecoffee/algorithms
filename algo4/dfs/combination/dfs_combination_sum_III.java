package combination;

import java.util.ArrayList;
import java.util.List;

public class dfs_combination_sum_III
{
    public List<List<Integer>> combinationSum3(int k, int n)
    {
        List<List<Integer>> result = new ArrayList<>();;
        backtracking(k, 1, 0, n, result, new ArrayList<Integer>());
        return result;
    }

    private void backtracking(int k, int start, int sum, int target, List<List<Integer>> result, List<Integer> path)
    {
        if (path.size() == k && sum == target) {
            result.add(new ArrayList<Integer>(path));
            return;
        } else if (path.size() == k) {
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = start; i < 10; ++i) {
            path.add(i);
            backtracking(k, i + 1, sum + i, target, result, path);
            path.remove(path.size() - 1);
        }
    }
}

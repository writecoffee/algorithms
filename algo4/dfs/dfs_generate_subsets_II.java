import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 *
 * Note:
 *
 *    -- Elements in a subset must be in non-descending order.
 *    -- The solution set must not contain duplicate subsets.
 *
 * For example,
 *
 * If S = [1,2,2], a solution is:
 *
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/subsets-ii/}
 *
 */
public class dfs_generate_subsets_II
{
    public List<List<Integer>> subsetsWithDup(int[] nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        explore(nums, 0, nums.length, new Stack<Integer>(), result);
        return result;
    }

    private void explore(int[] nums, int i, int n, Stack<Integer> path, List<List<Integer>> result)
    {
        result.add(new ArrayList<Integer>(path));

        for (int j = i; j < n; j++) {
            if (i != j && nums[j] == nums[j - 1]) {
                continue;
            }

            path.push(nums[j]);
            explore(nums, j + 1, n, path, result);
            path.pop();
        }
    }
}

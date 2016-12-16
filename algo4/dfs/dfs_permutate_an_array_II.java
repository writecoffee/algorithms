import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * For example,
 * 
 * [1,1,2] have the following unique permutations:
 * 
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/permutations-ii/}
 *
 */
public class dfs_permutate_an_array_II
{
    public List<List<Integer>> permuteUnique(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        explore(nums, nums.length, result, new HashSet<Integer>(), new Stack<Integer>());
        return result;
    }

    private void explore(int[] nums, int n, List<List<Integer>> result, HashSet<Integer> visited, Stack<Integer> path)
    {
        if (path.size() == n) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int j = 0; j < n; ++j) {
            int val = nums[j];

            if (visited.contains(j) || (j > 0 && val == nums[j - 1] && !visited.contains(j - 1))) {
                continue;
            }

            path.push(val);
            visited.add(j);
            explore(nums, n, result, visited, path);
            visited.remove(j);
            path.pop();
        }
    }
}

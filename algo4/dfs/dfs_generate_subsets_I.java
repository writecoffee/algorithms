import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Stack;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 *
 *    -- Elements in a subset must be in non-descending order.
 *    -- The solution set must not contain duplicate subsets.
 *
 * For example,
 *
 * If S = [1,2,3], a solution is:
 *
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/subsets/}
 *
 */
public class dfs_generate_subsets_I
{
    public List<List<Integer>> subsets(int[] nums)
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
            path.push(nums[j]);
            explore(nums, j + 1, n, path, result);
            path.pop();
        }
    }

    public List<List<Integer>> generateSubsetsNonrecur(int[] num)
    {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(num);

        for (Integer val : num) {
            List<List<Integer>> t = new ArrayList<>();

            /*
             * We cannot iterate and mutate the result at the same time, that's why
             * we need "t".
             */
            for (List<Integer> pre : result) {
                List<Integer> nxt = new ArrayList<>(pre);
                nxt.add(val);
                t.add(nxt);
            }

            result.addAll(t);
        }

        return result;
    }
}

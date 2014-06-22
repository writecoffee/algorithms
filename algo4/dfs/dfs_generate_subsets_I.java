import java.util.ArrayList;
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
public class dfs_generate_subsets_I {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        explore(nums, 0, nums.length, new Stack<Integer>(), result);
        return result;
    }

    private void explore(int[] nums, int i, int n, Stack<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (i == n) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        explore(nums, i + 1, n, path, result);
        path.push(nums[i]);
        explore(nums, i + 1, n, path, result);
        path.pop();
    }

    public ArrayList<ArrayList<Integer>> generateSubsetsNonrecur(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(num);

        for (Integer val : num) {
            ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> pre : result) {
                ArrayList<Integer> nxt = new ArrayList<Integer>(pre);
                nxt.add(val);
                t.add(nxt);
            }

            result.addAll(t);
        }

        return result;
    }
}
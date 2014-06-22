import java.util.ArrayList;
import java.util.Arrays;
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
public class dfs_generate_subsets_II {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        explore(nums, 0, nums.length, false, new Stack<Integer>(), result);
        return result;
    }

    private void explore(int[] nums, int i, int n, boolean last, Stack<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (i == n) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (last || i == 0 || nums[i - 1] != nums[i]) {
            path.push(nums[i]);
            explore(nums, i + 1, n, true, path, result);
            path.pop();
        }

        explore(nums, i + 1, n, false, path, result);
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDupNonrecur(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        int n = nums.length;

        for (int i = 0, dc = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                ++dc;
            } else {
                dc = 0;
            }

            ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> pre : result) {
                if (dc == 0 || (pre.size() >= dc && pre.get(pre.size() - dc) == nums[i])) {
                    ArrayList<Integer> nxt = new ArrayList<Integer>(pre);
                    nxt.add(nums[i]);
                    t.add(nxt);
                }
            }

            result.addAll(t);
        }

        return result;
    }
}
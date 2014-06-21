import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * 
 * [1,2,3] have the following permutations:
 * 
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/permutations/}
 * 
 */
public class dfs_permutate_an_array_I {
    public ArrayList<ArrayList<Integer>> permute(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        explore(nums, 0, nums.length, result, new HashSet<Integer>(), new Stack<Integer>());
        return result;
    }

    private void explore(int[] nums, int i, int n, ArrayList<ArrayList<Integer>> result, HashSet<Integer> visited, Stack<Integer> stk) {
        if (i == n) {
            result.add(new ArrayList<Integer>(stk));
            return;
        }

        for (int j = 0; j < n; ++j) {
            int val = nums[j];

            if (!visited.contains(val)) {
                stk.push(val);
                visited.add(val);
                explore(nums, i + 1, n, result, visited, stk);
                visited.remove(val);
                stk.pop();
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute2(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        int n = nums.length;

        for (int i = 0; i < n; ++i) {
            ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> pre : result) {
                for (int j = 0; j <= pre.size(); ++j) {
                    ArrayList<Integer> nxt = new ArrayList<Integer>(pre);
                    nxt.add(j, nums[i]);
                    t.add(nxt);
                }
            }

            result = t;
        }

        return result;
    }
}

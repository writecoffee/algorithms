import java.util.ArrayList;
import java.util.Arrays;
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
public class dfs_permutate_an_array_II {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        explore(nums, nums.length, new Stack<Integer>(), new boolean[nums.length], result);
        return result;
    }

    private void explore(int[] nums, int n, Stack<Integer> path, boolean[] visited, ArrayList<ArrayList<Integer>> result) {
        if (path.size() == n) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0, last = -1; i < n; ++i) {
            if (!visited[i] && (last == -1 || nums[i] != nums[last])) {
                visited[i] = true;
                path.add(nums[i]);
                explore(nums, n, path, visited, result);
                path.pop();
                visited[i] = false;
                last = i;
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permuteUnique2(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        explore2(nums, nums.length, new Stack<Integer>(), new boolean[nums.length], result);
        return result;
    }

    private void explore2(int[] nums, int n, Stack<Integer> path, boolean[] visited, ArrayList<ArrayList<Integer>> result) {
        if (path.size() == n) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        ArrayList<Integer> t = new ArrayList<Integer>();

        for (int j = 0; j < n; ++j) {
            if (!visited[j] && (t.isEmpty() || nums[t.get(t.size() - 1)] != nums[j])) {
                t.add(j);
            }
        }

        for (int j : t) {
            visited[j] = true;
            path.push(nums[j]);
            explore(nums, n, path, visited, result);
            path.pop();
            visited[j] = false;
        }
    }
}
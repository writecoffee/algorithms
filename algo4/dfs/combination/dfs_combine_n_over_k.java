package combination;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/combinations/}
 *
 */
public class dfs_combine_n_over_k {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        explore(0, n, k, new Stack<Integer>(), result);
        return result;
    }

    private void explore(int start, int n, int k, Stack<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int j = start + 1; j <= n; ++j) {
            path.push(j);
            explore(j, n, k, path, result);
            path.pop();
        }
    }

    public ArrayList<ArrayList<Integer>> combineNonrecur(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);

        while (true) {
            if (s.pop() > n) {
                if (s.size() == 1) {
                    break;
                }

                s.pop();
                s.push(s.pop() + 1);
            } else if (s.size() == k) {
                result.add(new ArrayList<Integer>(s));
                s.push(s.pop() + 1);
            } else {
                s.push(s.peek() + 1);
            }
        }

        return result;
    }
}
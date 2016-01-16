package memorization_search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 *
 * Write a function that takes an integer n and return all possible combinations
 * of its factors.
 *
 * Note:
 *
 * Each combination's factors must be sorted ascending, for example: The factors
 * of 2 and 6 is [2, 6], not [6, 2]. You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 *
 * Examples:
 *
 * input: 1
 * output: []
 *
 * input: 37
 * output: []
 *
 * input: 12
 * output:
 *
 * [
 *  [2, 6],
 *  [2, 2, 3],
 *  [3, 4]
 * ]
 *
 * input: 32
 * output:
 *
 * [
 *  [2, 16],
 *  [2, 2, 8],
 *  [2, 2, 2, 4],
 *  [2, 2, 2, 2, 2],
 *  [2, 4, 4],
 *  [4, 8]
 * ]
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/factor-combinations/}
 * [Difficulty] - Medium
 *
 */
public class dp_ms_get_factors
{
    public List<List<Integer>> getFactors(int n)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 3) {
            return result;
        }

        explore(n, -1, result, new Stack<>());
        return result;
    }

    public void explore(int n, int lower, List<List<Integer>> result, Stack<Integer> path)
    {
        if (lower != -1) {
            path.push(n);
            result.add(new ArrayList<>(path));
            path.pop();
        }

        int upper = (int) Math.sqrt(n);
        for (int i = Math.max(2, lower); i <= upper; ++i) {
            if (n % i == 0) {
                path.push(i);
                explore(n / i, i, result, path);
                path.pop();
            }
        }
    }
}

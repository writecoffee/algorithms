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
public class dfs_get_factors
{
    public List<List<Integer>> getFactors(int n)
    {
        List<List<Integer>> result = new ArrayList<>();

        Stack<Integer> path = new Stack<>();
        explore(2, n, path, result);

        return result;
    }

    /**
     * Time complexity: sqrt(n) * log(n), where log(n) means there are at most log(n) levels, each level
     * there'd be at most sqrt(n) iteration
     */
    private void explore(int startingFactor, int n, Stack<Integer> path, List<List<Integer>> result)
    {
        if (n <= 3) {
            return;
        }

        // avoid generating repetitive result, such as 12 -> [2, 6], [2, 2, 3] and [2, 3, 2] where
        // the last one is duplicate.
        int maxFactor = (int) Math.sqrt(n);
        for (int factor = startingFactor; factor <= maxFactor; factor++) {
            if (n % factor == 0) {
                path.push(factor);

                int quotient = n / factor;
                path.push(quotient);
                result.add(new ArrayList<>(path));
                path.pop();

                explore(factor, quotient, path, result);

                path.pop();
            }
        }
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 *
 * Given [100, 4, 200, 1, 3, 2],
 *
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Try using the union find algorithm.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/longest-consecutive-sequence/}
 *
 */
public class uf_longest_consecutive_sequence
{
    public int longestConsecutive(int[] nums)
    {
        int n = nums.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> groupLength = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int number = nums[i],
                left = number - 1,
                right = number + 1,
                leftBound = 0,
                rightBound = 0,
                leftLeader = find(map, left);

            if (map.containsKey(number)) {
                continue;
            }

            if (map.containsKey(left)) {
                leftBound = groupLength.get(leftLeader);
            }

            if (map.containsKey(right)) {
                rightBound = groupLength.get(right);
            }

            if (leftBound > 0 && rightBound > 0) {
                map.put(right, leftLeader);
                map.put(number, leftLeader);
                groupLength.put(leftLeader, rightBound + 1 + leftBound);
            } else if (leftBound > 0) {
                map.put(number, leftLeader);
                groupLength.put(leftLeader, leftBound + 1);
            } else if (rightBound > 0) {
                map.put(number, number);
                map.put(right, number);
                groupLength.put(number, rightBound + 1);
            } else {
                map.put(number, number);
                groupLength.put(number, 1);
            }

            result = Math.max(result, leftBound + 1 + rightBound);
        }

        return result;
    }

    private int find(Map<Integer, Integer> map, int x)
    {
        if (!map.containsKey(x)) {
            return -1;
        }

        while (x != map.get(x)) {
            x = map.get(x);
        }

        return x;
    }
}

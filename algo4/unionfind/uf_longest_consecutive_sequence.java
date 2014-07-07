import java.util.HashMap;

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
public class uf_longest_consecutive_sequence {
    public int merge(HashMap<Integer, Integer> map, int l, int r) {
        int lb = l - map.get(l) + 1;
        int rb = r + map.get(r) - 1;
        int length = rb - lb + 1;
        map.put(lb, length);
        map.put(rb, length);
        return length;
    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int gMax = (nums.length == 0) ? 0 : 1;

        for (int num : nums) {
            if (!h.containsKey(num)) {
                h.put(num, 1);

                if (h.containsKey(num - 1)) {
                    gMax = Math.max(gMax, merge(h, num - 1, num));
                }

                if (h.containsKey(num + 1)) {
                    gMax = Math.max(gMax, merge(h, num, num + 1));
                }
            }
        }

        return gMax;
    }
}
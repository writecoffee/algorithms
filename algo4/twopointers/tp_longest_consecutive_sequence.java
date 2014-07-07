import java.util.HashSet;

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
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/longest-consecutive-sequence/}
 * 
 */
public class tp_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        int gMax = 0;
        HashSet<Integer> h = new HashSet<Integer>();

        for (int num : nums) {
            h.add(num);
        }

        for (int num : nums) {
            int l = num - 1, r = num + 1;

            while (h.contains(l)) {
                h.remove(l--);
            }

            while (h.contains(r)) {
                h.remove(r++);
            }

            gMax = Math.max(gMax, r - l - 1);
        }

        return gMax;
    }
}
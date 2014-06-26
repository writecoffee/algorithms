/**
 * Given an array of non-negative integers, you are initially positioned at the first
 * index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * 
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/jump-game/}
 *
 */
public class gd_jump_game_I {
    public boolean canJump(int[] array) {
        int n = array.length;

        for (int i = 0; i + array[i] < n - 1;) {
            if (array[i] == 0) {
                return false;
            }

            int next = i + 1;
            for (int j = i + 1; j <= i + array[i]; ++j) {
                if (j - i + array[j] > next - i + array[next]) {
                    next = j;
                }
            }

            i = next;
        }

        return true;
    }
}
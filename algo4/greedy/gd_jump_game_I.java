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
public class gd_jump_game_I
{
    public boolean canJump(int[] nums)
    {
        int n = nums.length;
        int lastReachableIndex = n - 1;

        for (int i = n - 2; i >= 0; i--) {
            if (lastReachableIndex - i <= nums[i]) {
                lastReachableIndex = i;
            }
        }

        return lastReachableIndex == 0;
    }
}

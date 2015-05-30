/**
 * Given an array of non-negative integers, you are initially positioned at the first
 * index of the array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * 
 * Given array A = [2,3,1,1,4]
 * 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index
 * 0 to 1, then 3 steps to the last index.)
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/jump-game-ii/}
 *
 */
public class gd_jump_game_II
{
    public int jump(int[] array)
    {
        int minSteps = 0;
        int currentBoundary = 0;
        int newBoundary = 0;

        for (int i = 0; i < array.length - 1; i++) {
            newBoundary = Math.max(newBoundary, i + array[i]);

            if (i == currentBoundary) {
                minSteps++;
                currentBoundary = newBoundary;
            }
        }

        return minSteps;
    }
}

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 *
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 *
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 *
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/trapping-rain-water/}
 * [Difficulty] - Medium
 *
 */
public class stk_trapping_rain_water
{
    public int trap(int[] heights)
    {
        int n = heights.length;
        Stack<Integer> stk = new Stack<Integer>();
        int water = 0, i = 0;

        while (i < n) {
            if (stk.isEmpty() || heights[stk.peek()] > heights[i]) {
                stk.push(i++);
            } else {
                int bottom = heights[stk.pop()];
                int left = stk.isEmpty() ? i - 1 : stk.peek();

                water += (Math.min(heights[left], heights[i]) - bottom) * (i - left - 1);
            }
        }

        return water;
    }
}

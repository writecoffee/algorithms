/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/container-with-most-water/}
 * [Difficulty] - Medium
 *
 */
public class tp_container_with_most_water
{
    public int maxArea(int[] height)
    {
        int n = height.length, l = 0, r = n - 1;
        int gMax = 0;

        for (; l < r;) {
            gMax = Math.max(gMax, (r - l) * Math.min(height[l], height[r]));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return gMax;
    }
}

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate
 * (i, ai). n vertical lines are drawn such that the two end points of line i is at (i, ai) and
 * (i, 0). Find two lines, which together with x-axis forms a container, such that the container
 * contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/container-with-most-water/}
 * 
 */
public class gd_container_with_most_water {
    public int maxArea(int[] height) {
        int n = height.length, l = 0, r = n - 1, gMax = 0;

        while (l < r) {
            gMax = Math.max(gMax, (r - l) * Math.min(height[l], height[r]));

            int lh = height[l], rh = height[r];
            if (lh < rh) {
                l++;
                while (l < r && height[l] <= lh) {
                    l++;
                }
            } else {
                r--;
                while (l < r && height[r] <= rh) {
                    r--;
                }
            }
        }

        return gMax;
    }
}
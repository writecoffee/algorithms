
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
public class tp_trapping_rain_water
{
    public int trap(int[] heights)
    {
        int n = heights.length;
        int water = 0;

        for (int i = 0, j = n - 1; i < j - 1; ) {
            int lh = heights[i];
            int rh = heights[j];

            if (lh < rh) {
                int nlh = heights[i + 1];
                water += Math.max(0, lh - nlh);
                heights[i + 1] += Math.max(0, lh - nlh);
                i++;
            } else {
                int nrh = heights[j - 1];
                water += Math.max(0, rh - nrh);
                heights[j - 1] += Math.max(0, rh - nrh);
                j--;
            }
        }

        return water;
    }
}

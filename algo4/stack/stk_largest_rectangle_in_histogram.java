import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar
 * is 1, find the area of largest rectangle in the histogram.
 *
 *
 * Above is a histogram where width of each bar is 1, given height = [2, 1, 5, 6, 2, 3].
 *
 *
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 *
 * For example,
 *
 * Given height = [2, 1, 5, 6, 2, 3],
 *
 * return 10.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/largest-rectangle-in-histogram/}
 * [Difficulty] - Hard
 *
 */
public class stk_largest_rectangle_in_histogram
{
    /**
     * For each height we can look backwards to find the "bottleneck" height and
     * find the maximum rectangle over all n * n possible sizes of rectangles.
     *
     */
    public int largestRectangleAreaNaive(int[] heights)
    {
        int n = heights.length, area = 0;

        for (int i = 0; i < n; ++i) {
            int minHeight = heights[i];
            area = Math.max(area, minHeight * 1);

            for (int j = i - 1; j >= 0; --j) {
                minHeight = Math.min(minHeight, heights[j]);
                area = Math.max(area, minHeight * (i - j));
            }
        }

        return area;
    }

    /**
     * We can use a non-descending stack to keep track of the "bottleneck" height. In terms of
     * non-descending stack, it means at each position i we should update the stack and calculate
     * the maximum size over all previous possible rectangle ending at i - 1.
     *
     * For time complexity, because we hit each element in the input array at most twice so the
     * running time would be O(n).
     *
     */
    public int largestRectangleArea(int[] height)
    {
        int n = height.length;
        Stack<Integer> stk = new Stack<>();
        int result = 0;

        for (int i = 0; i <= n; i++) {
            int val;
            if (i == n) {
                val = 0;
            } else {
                val = height[i];
            }

            while (!stk.isEmpty() && height[stk.peek()] >= val) {
                int start = stk.pop();
                int width;

                if (stk.isEmpty()) {
                    width = i;
                } else {
                    width = i - stk.peek() - 1;
                }

                result = Math.max(result, width * height[start]);
            }

            stk.push(i);
        }

        return result;
    }
}

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
 */
public class largest_rectangle_in_histogram {
    /**
     * For each height we can look backwards to find the "bottleneck" height and find the maximum
     * rectangle over all n * n possible sizes of rectangles.
     * 
     */
    public int largestRectangleAreaNaive(int[] heights) {
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
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<Integer>();
        int i = 0, area = 0;
        int n = heights.length;

        while (i < n || !stk.isEmpty()) {
            if (stk.isEmpty() || (i < n && heights[i] >= heights[stk.peek()])) {
                stk.push(i++);
            } else {
                int h = heights[stk.pop()];
                int w = stk.isEmpty() ? i : (i - stk.peek() - 1);

                area = Math.max(area, h * w);
            }
        }

        return area;
    }
}
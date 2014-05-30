import java.util.Stack;

public class stk_trapping_rain_water {
    public int trap(int[] heights) {
        Stack<Integer> stk = new Stack<Integer>();
        int n = heights.length;
        int water = 0;
        int i = 0;

        while (i < n) {
            if (stk.isEmpty() || heights[i] < heights[stk.peek()]) {
                stk.push(i++);
            } else if (stk.size() == 1) {
                stk.pop();
            } else {
                int bottom = heights[stk.pop()];
                int bar = Math.min(heights[stk.peek()], heights[i]);
                int width = i - stk.peek() - 1;

                water += (bar - bottom) * width;
            }
        }

        return water;
    }
}

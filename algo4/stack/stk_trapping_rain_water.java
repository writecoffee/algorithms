import java.util.Stack;

public class stk_trapping_rain_water {
    public int trap(int[] heights) {
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

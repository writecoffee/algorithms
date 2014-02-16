import java.util.ArrayDeque;
import java.util.Deque;

public class largest_rectangle_in_histogram {
    public static int largestRectangleArea(int[] height) {
        Deque<Integer> left = new ArrayDeque<Integer>();
        int i = 0, area = 0;

        while (i < height.length) {
            if (left.isEmpty() || height[i] >= height[left.peekLast()]) {
                left.addLast(i++);
            } else {
                int top = left.pollLast();
                area = Math.max(area, height[top] * (left.isEmpty() ? i : (i - left.peekLast() - 1)));
            }
        }

        while (!left.isEmpty()) {
            int top = left.pollLast();
            area = Math.max(area, height[top] * (left.isEmpty() ? i : (i - left.peekLast() - 1)));
        }

        return area;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[] { 2, 1, 5, 6, 2, 3 });
    }
}
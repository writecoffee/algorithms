import java.util.Stack;

public class trapping_rain_water {
    public int trap(int[] array) {
        int n = array.length;
        Stack<Integer> s = new Stack<Integer>();
        int result = 0;
        int i = 0;

        while (i < n) {
            if (s.isEmpty() || array[i] < array[s.peek()]) {
                s.push(i++);
            } else if (array[i] >= array[s.peek()]) {
                int bottom = s.pop();
                if (s.isEmpty()) {
                    continue;
                }

                int bar = array[i] < array[s.peek()] ? i : s.peek();
                result += (i - s.peek() - 1) * (array[bar] - array[bottom]);
            }
        }

        return result;
    }
}

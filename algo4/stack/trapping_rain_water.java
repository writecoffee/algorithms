import java.util.ArrayDeque;
import java.util.Deque;

public class trapping_rain_water {
    public static int trap(int[] A) {
        int i = 0;
        while (i < A.length && A[i] == 0) {
            ++i;
        }

        int volumn = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (i < A.length) {
            while (!stack.isEmpty() && A[i] >= A[stack.peekLast()]) {
                int bottom = stack.pollLast();
                if (stack.isEmpty()) {
                    break;
                }

                int width = i - stack.peekLast() - 1;
                int height = Math.min(A[i], A[stack.peekLast()]) - A[bottom];
                volumn += width * height;
            }

            stack.addLast(i);
            ++i;
        }

        return volumn;
    }

    public static void main(String[] args) {
        trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
    }
}
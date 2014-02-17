import java.util.ArrayDeque;
import java.util.Deque;

public class trapping_rain_water {
    public static int trap(int[] A) {
        int i = 0;
        while (i < A.length && A[i] == 0) {
            ++i;
        }

        int volumn = 0;
        Deque<Integer> left = new ArrayDeque<Integer>();
        while (i < A.length) {
            if (left.isEmpty() || A[i] < A[left.peekLast()]) {
                left.addLast(i);
                i++;
            } else {
                int bottom = left.pollLast();

                int width = left.isEmpty() ? 0 : i - left.peekLast() - 1;
                int height = left.isEmpty() ? 0 : Math.min(A[left.peekLast()], A[i]) - A[bottom];
                volumn = volumn + width * height;
            }
        }

        return volumn;
    }

    public static void main(String[] args) {
        trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 });
    }
}
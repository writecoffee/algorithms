import java.util.HashSet;
import java.util.Set;

public class longest_consecutive_sequence {

    public static int longestConsecutive(int[] num) {
        Set<Integer> s = new HashSet<Integer>();
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            s.add(num[i]);
        }

        for (int i = 0; i < num.length; i++) {
            int upper = num[i];
            int lower = num[i];

            while (s.contains(upper + 1)) {
                s.remove(++upper);
            }

            while (s.contains(lower - 1)) {
                s.remove(--lower);
            }

            result = Math.max(result, upper - lower + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[] {100, 4, 200, 1, 3, 2 });
    }
}
import java.util.HashSet;

public class tp_longest_consecutive_sequence {
    public int longestConsecutive(int[] num) {
        HashSet<Integer> h = new HashSet<Integer>();
        int n = num.length;
        int gMax = 1;

        for (int i = 0; i < n; ++i) {
            h.add(num[i]);
        }

        for (int i = 0; i < n; ++i) {
            if (h.contains(num[i])) {
                int l = num[i] - 1, r = num[i] + 1;

                while (h.contains(l)) {
                    h.remove(l--);
                }

                while (h.contains(r)) {
                    h.remove(r++);
                }

                gMax = Math.max(gMax, r - l - 1);
            }
        }

        return gMax;
    }
}
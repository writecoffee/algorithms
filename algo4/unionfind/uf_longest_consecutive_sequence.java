import java.util.HashMap;
import java.util.HashSet;

public class uf_longest_consecutive_sequence {
    public int merge(HashMap<Integer, Integer> map, int l, int r) {
        int lb = l - map.get(l) + 1;
        int rb = r + map.get(r) - 1;
        int length = rb - lb + 1;
        map.put(lb, length);
        map.put(rb, length);
        return length;
    }

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
        int gMax = (nums.length == 0) ? 0 : 1;

        for (int num : nums) {
            if (!h.containsKey(num)) {
                h.put(num, 1);

                if (h.containsKey(num - 1)) {
                    gMax = Math.max(gMax, merge(h, num - 1, num));
                }

                if (h.containsKey(num + 1)) {
                    gMax = Math.max(gMax, merge(h, num, num + 1));
                }
            }
        }

        return gMax;
    }
}

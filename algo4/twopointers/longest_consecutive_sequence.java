import java.util.HashMap;
import java.util.HashSet;

public class longest_consecutive_sequence {
    public static int longestConsecutive(int[] num) {
        HashSet<Integer> s = new HashSet<Integer>();
        int n = num.length;

        for (int i = 0; i < n; ++i) {
            s.add(num[i]);
        }

        int gMax = 0;
        for (int i = 0; i < n; ++i) {
            if (s.contains(num[i])) {
                int j = num[i] + 1;
                int k = num[i] - 1;

                while (s.contains(j)) {
                    s.remove(j++);
                }

                while (s.contains(k)) {
                    s.remove(k--);
                }

                gMax = Math.max(gMax, j - k - 1);
            }
        }

        return gMax;
    }

    public static int merge(HashMap<Integer, Integer> map, int l, int r) {
        int lb = l - map.get(l) + 1;
        int rb = r + map.get(r) - 1;
        int length = rb - lb + 1;
        map.put(lb, length);
        map.put(rb, length);
        return length;
    }

    public static int longestConsecutiveUnionFind(int[] nums) {
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

    public static void main(String[] args) {
        longestConsecutiveUnionFind(new int[] { 100, 4, 200, 1, 3, 2 });
    }
}
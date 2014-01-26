import java.util.HashMap;
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

    public static int merge(HashMap<Integer, Integer> map, int l, int r) {
        int left = l - map.get(l) + 1;
        int right = r + map.get(r) - 1;
        int range = right - left + 1;
        map.put(left, range);
        map.put(right, range);
        return range;
    }

    public static int longestConsecutiveUnionFind(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxLen = (nums.length == 0) ? 0 : 1;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);

                if (map.containsKey(num - 1)) {
                    maxLen = Math.max(maxLen, merge(map, num - 1, num));
                }

                if (map.containsKey(num + 1)) {
                    maxLen = Math.max(maxLen, merge(map, num, num + 1));
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        longestConsecutiveUnionFind(new int[] { 100, 4, 200, 1, 3, 2 });
    }
}
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class two_sum {
    public class Pair {
        final int val;
        final int origIndex;

        Pair(int first, int second) {
            this.val = first;
            this.origIndex = second;
        }
    }

    public int[] twoSumUsingSort(int[] numbers, int target) {
        assert numbers.length > 0;

        int n = numbers.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(numbers[i], i + 1);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.val - b.val;
            }
        });

        int l = 0;
        int r = numbers.length - 1;
        while (l <= r) {
            int sum = pairs[l].val + pairs[r].val;

            if (sum == target) {
                return new int[] {
                    Math.min(pairs[l].origIndex, pairs[r].origIndex),
                    Math.max(pairs[l].origIndex, pairs[r].origIndex)
                };
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }

        return null;
    }

    /**
     * Contract: we will have exactly one answer; return value should never be {@code null}.
     * 
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        assert numbers.length > 0;

        HashMap<Integer, Integer> targetMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; ++i) {
            targetMap.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; ++i) {
            if (targetMap.containsKey(target - numbers[i]) && targetMap.get(target - numbers[i]) != i + 1) {
                return new int[] { i + 1, targetMap.get(target - numbers[i]) };
            }
        }

        return null;
    }
}
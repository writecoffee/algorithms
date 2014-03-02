import java.util.ArrayList;
import java.util.HashSet;

public class partition_array_with_equal_sum {
    private static Integer[][] partition(Integer[] arr) {
        HashSet<Integer> allElements = new HashSet<Integer>();
        ArrayList<Integer> part = new ArrayList<Integer>();

        int halfSum = 0;
        for (Integer num : arr) {
            allElements.add(num);
            halfSum += num;
        }
        if (halfSum % 2 == 1) {
            return null;
        }
        halfSum /= 2;

        int[][] dp = new int[arr.length + 1][halfSum + 1];
        for (int i = 1; i <= arr.length; ++i) {
            for (int s = 1; s <= halfSum; ++s) {
                if (arr[i - 1] > s || dp[i - 1][s] > arr[i - 1] + dp[i - 1][s - arr[i - 1]]) {
                    dp[i][s] = dp[i - 1][s];
                } else {
                    dp[i][s] = arr[i - 1] + dp[i - 1][s - arr[i - 1]];
                }
            }
        }

        if (dp[arr.length][halfSum] != halfSum) {
            return null;
        }

        int i = arr.length;
        int s = halfSum;
        while (s > 0 && i > 0) {
            if (arr[i - 1] <= s && dp[i][s] == arr[i - 1] + dp[i - 1][s - arr[i - 1]]) {
                part.add(arr[i - 1]);
                s = s - arr[i - 1];
            }

            i--;
        }

        for (Integer num : part) {
            allElements.remove(num);
        }

        Integer[][] result = new Integer[2][];
        result[0] = part.toArray(new Integer[] {});
        result[1] = allElements.toArray(new Integer[] {});

        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 10, 11 };
        partition(arr);
    }
}
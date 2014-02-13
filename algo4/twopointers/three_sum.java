import java.util.ArrayList;
import java.util.Arrays;

public class three_sum {
    static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);

        int N = num.length;
        for (int i = 0; i < N - 2 && num[i] <= 0; i++) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int expectedTwoSum = 0 - num[i];
            int l = i + 1;
            int r = N - 1;
            while (l < r) {
                int sum = num[l] + num[r];
                if (sum < expectedTwoSum) {
                    ++l;
                } else if (sum > expectedTwoSum) {
                    --r;
                } else {
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(num[i]);
                    triple.add(num[l]);
                    triple.add(num[r]);
                    result.add(triple);

                    l++;
                    r--;
                    while (l < r && num[l] == num[l - 1]) {
                        l++;
                    }
                    while (l < r && num[r] == num[r + 1]) {
                        r--;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        threeSum(new int[] { -2, 0, 1, 1, 2 });
    }
}

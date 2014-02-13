import java.util.ArrayList;
import java.util.Arrays;

public class four_sum {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (num.length < 4) {
            return result;
        }

        Arrays.sort(num);

        for (int i = 0; i < num.length - 3; ++i) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < num.length - 2; ++j) {
                if (j > i + 1 && num[j] == num[j - 1]) {
                    continue;
                }

                int l = j + 1, r = num.length - 1;
                while (l < r) {
                    int sum = num[i] + num[j] + num[l] + num[r];

                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        ArrayList<Integer> newResult = new ArrayList<Integer>(4);
                        newResult.add(num[i]);
                        newResult.add(num[j]);
                        newResult.add(num[l]);
                        newResult.add(num[r]);
                        result.add(newResult);

                        do {
                            l++;
                        } while (l < r && num[l] == num[l - 1]);
                        do {
                            r--;
                        } while (l < r && num[r] == num[r + 1]);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
    }
}
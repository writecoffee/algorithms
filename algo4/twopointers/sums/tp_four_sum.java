package sums;

import java.util.ArrayList;
import java.util.Arrays;

public class tp_four_sum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n = num.length;

        for (int i = 0; i < n - 3; ++i) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; ++j) {
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
                        result.add(convert(num, i, j, l++, r--));

                        while (l < r && num[l] == num[l - 1]) {
                            l++;
                        }

                        while (l < r && num[r] == num[r + 1]) {
                            r--;
                        }
                    }
                }
            }
        }

        return result;
    }

    private ArrayList<Integer> convert(int[] num, int i, int j, int l, int r) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(num[i]);
        result.add(num[j]);
        result.add(num[l]);
        result.add(num[r]);
        return result;
    }
}
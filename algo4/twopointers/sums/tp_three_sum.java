package sums;

import java.util.ArrayList;
import java.util.Arrays;

public class tp_three_sum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        int n = num.length;

        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && num[i] == num[i - 1]) {
                continue;
            }

            int l = i + 1, r = n - 1;
            int target = 0 - num[i];

            while (l < r) {
                int tsum = num[l] + num[r];

                if (tsum == target) {
                    ArrayList<Integer> t = new ArrayList<Integer>();
                    t.add(num[i]);
                    t.add(num[l]);
                    t.add(num[r]);
                    result.add(t);
                    l++;
                    r--;
                    while (l < r && num[l] == num[l - 1]) {
                        l++;
                    }
                } else if (tsum < target) {
                    l++;
                } else if (tsum > target) {
                    r--;
                }
            }
        }

        return result;
    }
}

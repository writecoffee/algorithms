package sums;

import java.util.Arrays;

public class tp_three_sum_closest {
    public int threeSumClosest(int[] num, int target) {
        int n = num.length;
        Arrays.sort(num);
        int result = num[0] + num[1] + num[2];

        for (int k = 0; k < n - 2; ++k) {
            int i = k + 1, j = n - 1;

            while (i < j) {
                int tsum = num[i] + num[j] + num[k];

                if (tsum == target) {
                    return tsum;
                } else if (tsum < target) {
                    i++;
                } else {
                    j--;
                }

                result = Math.abs(target - tsum) < Math.abs(target - result) ? tsum : result;
            }
        }

        return result;
    }
}
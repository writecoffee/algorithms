package sums;

import java.util.HashSet;

/**
 * Given an array of positive and negative numbers, find if there is a subarray with 0 sum.
 * 
 * Examples:
 * 
 * Input: {4, 2, -3, 1, 6}
 * Output: true 
 * There is a subarray with zero sum from index 1 to 3.
 * 
 * Input: {4, 2, 0, 1, 6}
 * Output: true 
 * There is a subarray with zero sum from index 2 to 2.
 * 
 * Input: {-3, 2, 3, 1, 6}
 * Output: false
 * There is no subarray with zero sum.
 * 
 * {@linkplain http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/}
 * 
 */
public class tp_find_sum_to_zero_subarray {
    public boolean hasZeroSubarray(int[] array) {
        int sum = 0;
        int n = array.length;
        HashSet<Integer> h = new HashSet<Integer>();
        h.add(0);

        for (int i = 0; i < n; ++i) {
            sum += array[i];

            if (h.contains(sum)) {
                return true;
            } else {
                h.add(sum);
            }
        }

        return false;
    }
}
package threepointers;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Note:
 * 
 * You may assume that A has enough space (size that is greater or equal to m + n)
 * to hold additional elements from B. The number of elements initialized in A and
 * B are m and n respectively.
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain https://oj.leetcode.com/problems/merge-sorted-array/}
 *
 */
public class tp_merge_two_sorted_arrays_in_place {
    public void merge(int array1[], int m, int array2[], int n) {
        for (int i = m - 1, j = n - 1, p = m + n - 1; j >= 0; --p) {
            if (i < 0) {
                array1[p] = array2[j--];
            } else if (array1[i] > array2[j]) {
                array1[p] = array1[i--];
            } else {
                array1[p] = array2[j--];
            }
        }
    }
}
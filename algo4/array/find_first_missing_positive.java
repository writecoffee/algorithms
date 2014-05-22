/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * 
 * Given [1,2,0] return 3,
 * 
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * https://oj.leetcode.com/problems/first-missing-positive/
 * 
 */
public class find_first_missing_positive {
    /**
     * 
     * Solution:
     * 
     * We can try to put each number in the array to match with an index based on array[i] == i + 1.
     * 
     * We also need to care with duplicate cases like [1, 1].
     * 
     * If each number can match with its index, then we should return the length of the array.
     * 
     */
    public int firstMissingPositive(int[] array) {
        int n = array.length;

        for (int i = 0; i < n; ++i) {
            while (array[i] > 0 && array[i] <= n && array[i] != i + 1 && array[i] != array[array[i] - 1]) {
                swap(array, i, array[i] - 1);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (array[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
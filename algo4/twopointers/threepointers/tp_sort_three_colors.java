package threepointers;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this problem.
 * 
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * 
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total
 * number of 0's, then 1's and followed by 2's.
 * 
 * The optimal solution should be an one-pass algorithm using only constant space.
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain https://oj.leetcode.com/problems/sort-colors/}
 * 
 */
public class tp_sort_three_colors {
    public void sortColors(int[] array) {
        int n = array.length;

        for (int i = -1, j = n, p = 0; p < j;) {
            int val = array[p];

            if (val == 0) {
                swap(array, ++i, p++);
            } else if (val == 1) {
                p++;
            } else {
                swap(array, --j, p);
            }
        }
    }

    private void swap(int[] array, int p1, int p2) {
        int t = array[p1];
        array[p1] = array[p2];
        array[p2] = t;
    }
}
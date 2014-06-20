/**
 * Given a sorted array, remove the duplicates in place such that each element appear only
 * once and return the new length.
 * 
 * Do not allocate extra space for another array, you must do this in place with constant
 * memory.
 * 
 * For example,
 * 
 * Given input array A = [1,1,2],
 * 
 * Your function should return length = 2, and A is now [1,2].
 * 
 * [Difficulty] - Easy
 * [Source]     - facebook interview, {@linkplain https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/}
 *
 */
public class tp_remove_duplicates_from_sorted_array_I {
    public int removeDuplicates(int[] array) {
        int n = array.length, j = 0;

        for (int i = 0; i < n; ++i) {
            if (i == 0 || array[i] != array[i - 1]) {
                array[j++] = array[i];
            }
        }

        return j;
    }
}
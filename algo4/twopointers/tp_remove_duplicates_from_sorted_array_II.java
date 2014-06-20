/**
 * Given a sorted array, remove the duplicates in place such that each element appear only
 * once and return the new length.
 * 
 * Now duplicates are allowed at most twice.
 * 
 * For example,
 * 
 * Given sorted array A = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/}
 *
 */
public class tp_remove_duplicates_from_sorted_array_II {
    /**
     * There is a trap if we use array[i - 2] to determine double duplicates.
     * 
     * [1,1,1,2,2,3] would become [1,1,2,3] because we overwrite original space.
     * 
     */
    public int removeDuplicates(int[] array) {
        int n = array.length, j = 0;

        for (int i = 0; i < n; ++i) {
            if (i == 0 || i == 1 || array[i] != array[j - 2]) {
                array[j++] = array[i];
            }
        }

        return j;
    }
}
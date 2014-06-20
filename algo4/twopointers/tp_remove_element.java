/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/remove-element/}
 * 
 */
public class tp_remove_element {
    public int removeElement(int[] array, int elem) {
        int n = array.length, j = 0;

        for (int i = 0; i < n; ++i) {
            if (array[i] != elem) {
                array[j++] = array[i];
            }
        }

        return j;
    }
}
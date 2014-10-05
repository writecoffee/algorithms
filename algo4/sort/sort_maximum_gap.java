/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form.
 *
 * Try to solve it in linear time/space.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * You may assume all elements in the array are non-negative integers and fit in
 * the 32-bit signed integer range.
 *
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/maximum-gap/}
 *
 */
public class sort_maximum_gap
{
    public int maximumGap(int[] array)
    {
        int n = array.length;

        for (int i = 0; i < 32; i++) {
            int[] counter = new int[2];

            for (int number : array) {
                counter[(number >>> i) & 1]++;
            }

            counter[1] += counter[0];

            int[] aux = new int[n];
            for (int j = n - 1; j >= 0; j--) {
                int number = array[j];
                aux[--counter[(number >>> i) & 1]] = number;
            }

            array = aux;
        }

        int result = 0;
        for (int i = 1; i < n; i++) {
            result = Math.max(result, array[i] - array[i - 1]);
        }

        return result;
    }
}

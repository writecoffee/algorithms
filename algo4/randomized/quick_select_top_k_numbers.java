import java.util.ArrayList;
import java.util.Random;

/**
 * Find K-th largest element in an array.
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * In array [9,3,2,4,8], the 3rd largest element is 4.
 *
 * In array [1,2,3,4,5], the 1st largest element is 5, 2nd largest element is 4,
 * 3rd largest element is 3 and etc.
 *
 * Note
 *
 * You can swap elements in the array
 *
 * Challenge
 *
 * O(n) time, O(1) extra memory.
 *
 *
 *
 * [Difficulty] - Hard
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/kth-largest-element/}
 *                Classical problem
 *
 */
public class quick_select_top_k_numbers
{
    private static Random r = new Random();

    public int kthLargestElement(int k, ArrayList<Integer> numbers)
    {
        Integer[] vs = new Integer[numbers.size()];
        numbers.toArray(vs);
        return qf(vs, 0, numbers.size(), numbers.size() + 1 - k);
    }

    private int qf(Integer[] numbers, int start, int end, int k)
    {
        int randomIndex = start + r.nextInt(end - start);
        swap(numbers, start, randomIndex);
        int pivot = numbers[start];

        int i = start + 1;
        int j = end - 1;

        for (; i <= j;) {
            if (numbers[i] <= pivot) {
                i++;
            } else if (numbers[j] > pivot) {
                j--;
            } else {
                swap(numbers, i++, j--);
            }
        }

        /*
         * Finally, put the pivot to its right position.
         */
        swap(numbers, start, j);

        if (i == k) {
            return pivot;
        } else if (i > k) {
            return qf(numbers, start, i - 1, k);
        } else {
            return qf(numbers, i, end, k);
        }
    }

    private void swap(Integer[] array, int i, int j)
    {
        int t = array[j];
        array[j] = array[i];
        array[i] = t;
    }
}

import java.util.ArrayList;
import java.util.Random;

/**
 * Select the k smallest elements from the input in Theta(n) time complexity.
 * 
 * Sample Input:
 * 
 * (1) array = { 1, 5, 2, 8, 9, 11 }, k = 3
 * (2) array = { 4, 6, 1, 1, 4 }, k = 2
 * (3) array = { 1, 1, 1, 1 }, k = 1
 * 
 * [Difficulty] - Medium
 * [Source]     - Classical problem
 *
 */
public class quick_select {
    private static Random r = new Random();

    public ArrayList<Integer> quickSelect(int[] array, int k) {
        return quickSelect(array, k, 0, array.length);
    }

    private ArrayList<Integer> quickSelect(int[] array, int k, int start, int end) {
        int finalRank = randomPartition(array, start, end);

        if (finalRank == k) {
            return convert(array, k);
        } else if (finalRank < k) {
            return quickSelect(array, k, finalRank, end);
        } else {
            return quickSelect(array, k, start, finalRank);
        }
    }

    private ArrayList<Integer> convert(int[] array, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < k; ++i) {
            result.add(array[i]);
        }

        return result;
    }

    private int randomPartition(int[] array, int start, int end) {
        swap(array, start, start + r.nextInt(end - start));
        return partition(array, start, end);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[start];
        int i = start + 1;

        for (int j = i; j < end; ++j) {
            if (array[j] < pivot) {
                swap(array, i++, j);
            }
        }

        swap(array, i - 1, start);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int t = array[j];
        array[j] = array[i];
        array[i] = t;
    }
}
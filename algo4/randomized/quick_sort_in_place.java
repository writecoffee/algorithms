import java.util.Random;

/**
 * Implement quick sort in place.
 * 
 * Sample Input:
 * 
 * (1) 1, 5, 2, 8, 9, 11 
 * (2) 4, 6, 1, 1, 4 
 * (3) 1, 1, 1, 1
 * 
 * [Difficulty] - Medium
 * [Source]     - Classical problem
 *
 */
public class quick_sort_in_place {
    private static Random r = new Random();

    public int[] quickSort(int[] array) {
        quickSort(array, 0, array.length);
        return array;
    }

    private void quickSort(int[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int finalRank = randomPartition(array, start, end);
        quickSort(array, start, finalRank);
        quickSort(array, finalRank + 1, end);
    }

    /**
     * After doing randomized selection and partitioning, the return value will
     * represent the final statistic order (0-base) of the random pivot in the array.
     * 
     */
    private int randomPartition(int[] array, int start, int end) {
        swap(array, start + r.nextInt(end - start), end - 1);
        return partition(array, start, end);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end - 1], i = start;

        for (int j = i; j < end - 1; ++j) {
            if (array[j] <= pivot) {
                swap(array, i++, j);
            }
        }

        swap(array, i, end - 1);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
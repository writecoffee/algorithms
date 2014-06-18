import java.util.Random;

/**
 * Find medium value of an unsorted array. If the array length is an even number,
 * it should return (array[n / 2 - 1] + array[n / 2]) / 2.
 * 
 * Sample Input:
 * 
 * (1) 4, 6, 1 => 4.0
 * (2) 1, 1, 1 => 1.0
 * (3) 1, 5, 2, 8, 9, 11 => 6.5
 * 
 * [Difficulty] - Medium
 * [Source]     - Classical problem
 *
 */
public class quick_select_median_of_an_unsorted_array {
    private static Random r = new Random();

    public double findMedian(int[] array) {
        assert array != null;
        assert array.length > 0;

        int n = array.length;

        if ((n & 1) == 1) {
            return findMedian(array, 0, n, n / 2 + 1);
        } else {
            return (findMedian(array.clone(), 0, n, n / 2) + findMedian(array, 0, n, n / 2 + 1)) / 2.0;
        }
    }

    private int findMedian(int[] array, int start, int end, int k) {
        if (end - start <= 1) {
            return array[start];
        }

        int finalRank = randomPartition(array, start, end);

        if (finalRank == k) {
            return array[finalRank - 1];
        } else if (finalRank > k) {
            return findMedian(array, start, finalRank - 1, k);
        } else {
            return findMedian(array, finalRank, end, k);
        }
    }

    private int randomPartition(int[] array, int start, int end) {
        swap(array, start + r.nextInt(end - start), start);
        return partition(array, start, end);
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end - 1], i = start;

        for (int j = i; j < end - 1; ++j) {
            if (array[j] < pivot) {
                swap(array, i++, j);
            }
        }

        swap(array, i, end - 1);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}
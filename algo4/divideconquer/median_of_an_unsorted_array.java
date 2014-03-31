import java.util.Random;

public class median_of_an_unsorted_array {
    private static Random r = new Random();

    static double findMedian(int[] array) {
        assert array != null;
        assert array.length > 0;

        int n = array.length;

        if ((n & 1) == 1) {
            return explore(array, 0, n, n / 2 + 1);
        } else {
            return (explore(array.clone(), 0, n, n / 2) +
                    explore(array, 0, n, n / 2 + 1)) * 1.0f / 2;
        }
    }

    static int explore(int[] array, int start, int end, int k) {
        int i = partition(array, start, end);

        if (i == k) {
            return array[i - 1];
        } else if (i > k) {
            return explore(array, start, i - 1, k);
        } else {
            return explore(array, i, end, k);
        }
    }

    /**
     * After doing randomized selection, i will represents the final rank
     * of the pivot in the array.
     * 
     */
    private static int partition(int[] array, int start, int end) {
        int i = start;
        int j = end - 1;
        int pivot = start + r.nextInt(end - start);

        while (i < j) {
            while (array[i] < array[pivot]) {
                i++;
            }

            while (array[j] > array[pivot]) {
                j--;
            }

            if (i < j) {
                swap(array, i++, j--);
            }
        }

        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
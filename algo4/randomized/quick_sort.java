import java.util.Random;

public class quick_sort {
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

    private static Random r = new Random();

    /**
     * After doing randomized selection and partitioning, the return value will
     * represents the final position of the pivot in the array.
     * 
     */
    private int randomPartition(int[] array, int start, int end) {
        swap(array, start + r.nextInt(end - start), end - 1);
        return partition(array, start, end);
    }

    private int partition(int[] array, int start, int end) {
        int x = array[end - 1];
        int i = start - 1;

        for (int j = start; j < end - 1; ++j) {
            if (array[j] <= x) {
                swap(array, ++i, j);
            }
        }

        swap(array, i + 1, end - 1);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
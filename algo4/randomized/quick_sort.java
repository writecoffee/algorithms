import java.util.Random;

public class quick_sort {
    static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length);
        return array;
    }

    static void quickSort(int[] array, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int pos = randomPartition(array, start, end);
        quickSort(array, start, pos);
        quickSort(array, pos + 1, end);
    }

    public static Random r = new Random();

    /**
     * After doing randomized selection and partitioning, the return value will
     * represents the final position of the pivot in the array.
     * 
     */
    private static int randomPartition(int[] array, int start, int end) {
        int j = end - 1;
        swap(array, start + r.nextInt(end - start), j);
        return partition(array, start, end);
    }

    private static int partition(int[] array, int start, int end) {
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

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 1, 5, 2, 8, 9, 11 };
        int[] result = quickSort(array);
        for (int i = 1; i < result.length; i++) {
            assert result[i] >= result[i - 1];
        }
        int[] array2 = new int[] { 4, 6, 1 };
        int[] result2 = quickSort(array2);
        for (int i = 1; i < result2.length; i++) {
            assert result2[i] >= result2[i - 1];
        }
        int[] array3 = new int[] { 1, 1, 1, 1 };
        int[] result3 = quickSort(array3);
        for (int i = 1; i < result3.length; i++) {
            assert result3[i] >= result3[i - 1];
        }
    }
}
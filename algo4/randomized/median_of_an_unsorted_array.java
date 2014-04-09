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
        if (end - start == 1) {
            return array[start];
        }

        int rank = randomPartition(array, start, end);

        if (rank == k) {
            return array[rank - 1];
        } else if (rank > k) {
            return explore(array, start, rank - 1, k);
        } else {
            return explore(array, rank, end, k);
        }
    }

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
        int j = start;

        for (; j < end - 1; ++j) {
            if (array[j] <= x) {
                swap(array, ++i, j);
            }
        }
        swap(array, i + 1, end - 1);

        return i + 2;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findMedian(new int[] { 4, 6, 1 }));
        System.out.println(findMedian(new int[] { 1, 1, 1 }));
        System.out.println(findMedian(new int[] { 1, 5, 2, 8, 9, 11 }));
    }
}
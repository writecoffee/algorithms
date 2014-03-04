public class merge_sort {
    static int[] mergeSort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length);
        return array;
    }

    private static void mergeSort(int[] array, int[] helper, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        int middle = (start + end) / 2;
        mergeSort(array, helper, start, middle);
        mergeSort(array, helper, middle, end);
        merge(array, helper, start, middle, end);
    }

    private static void merge(int[] array, int[] helper, int start, int middle, int end) {
        for (int i = start; i < end; i++) {
            helper[i] = array[i];
        }

        int iLeft = start;
        int iRight = middle;
        int i = start;

        while (iLeft < middle && iRight < end) {
            if (helper[iLeft] <= helper[iRight]) {
                array[i++] = helper[iLeft];
                iLeft++;
            } else {
                array[i++] = helper[iRight];
                iRight++;
            }
        }

        int remaining = middle - iLeft;
        for (int j = 0; j < remaining; j++) {
            array[i + j] = helper[iLeft + j];
        }
    }

    public static void main(String[] args) {
        int[] result = mergeSort(new int[] { 1, 5, 2, 8, 9 });
        for (int i = 1; i < result.length; i++) {
            assert result[i] >= result[i - 1];
        }
    }
}
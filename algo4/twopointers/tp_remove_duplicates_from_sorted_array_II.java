public class tp_remove_duplicates_from_sorted_array_II {
    public int removeDuplicates(int[] array) {
        int n = array.length;

        if (n < 3) {
            return n;
        }

        int j = 2;

        for (int i = 2; i < n; ++i) {
            if (!(array[i] == array[j - 1] && array[i] == array[j - 2])) {
                array[j++] = array[i];
            }
        }

        return j;
    }
}
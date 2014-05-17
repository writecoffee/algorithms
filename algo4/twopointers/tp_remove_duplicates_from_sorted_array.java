public class tp_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] array) {
        int n = array.length;

        if (n == 0) {
            return 0;
        }

        int j = 1;

        for (int i = 1; i < n; ++i) {
            if (array[i] != array[i - 1]) {
                array[j++] = array[i];
            }
        }

        return j;
    }
}
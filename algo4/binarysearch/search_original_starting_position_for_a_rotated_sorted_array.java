public class search_original_starting_position_for_a_rotated_sorted_array {
    public static int search(int[] array) {
        int n = array.length;
        int l = 0;
        int r = n - 1;

        /**
         * Edge case the array has only two values.
         */
        if (n == 2) {
            return array[0] > array[1] ? 1 : 0;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid == n - 1 || mid == 0) {
                break;
            }

            if (array[mid] < array[mid + 1] && array[mid] < array[mid - 1]) {
                return mid;
            } else if (array[mid] > array[mid + 1] && array[mid] > array[mid - 1]) {
                return mid + 1;
            }

            if (array[mid] > array[l]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        assert search(new int[] { 4, 5, 6, 7, 0, 1, 2 }) == 4;
        assert search(new int[] { 4, 5, 6, 0, 1, 2, 3 }) == 3;
        assert search(new int[] { 4, 1, 2, 3 }) == 1;
        assert search(new int[] { 1, 2, 3, 4 }) == 0;
        assert search(new int[] { 1, 2 }) == 0;
        assert search(new int[] { 2, 1 }) == 1;
        assert search(new int[] { 3, 1, 2 }) == 1;
        assert search(new int[] { 1, 2, 3 }) == 0;
    }
}
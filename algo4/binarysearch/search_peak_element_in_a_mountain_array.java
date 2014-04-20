public class search_peak_element_in_a_mountain_array {
    public static int search(int[] array) {
        int n = array.length;
        int l = 0;
        int r = n - 1;

        if (n == 2) {
            return array[0] > array[1] ? array[0] : array[1];
        }

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (mid == 0 || mid == n - 1) {
                return array[mid];
            } else if (array[mid] > array[mid - 1] && array[mid] > array[mid + 1]) {
                return array[mid];
            } else if (array[mid] > array[mid + 1] && array[mid] < array[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        assert search(new int[] { 1, 3, 20, 4, 3, 2, 1, 0 }) == 20;
        assert search(new int[] { 1, 2, 0 }) == 2;
        assert search(new int[] { 1, 0 }) == 1;
        assert search(new int[] { 0, 1 }) == 1;
    }
}
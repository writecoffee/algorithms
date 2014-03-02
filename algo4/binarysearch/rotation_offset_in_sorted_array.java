public class rotation_offset_in_sorted_array {
    public static int search(int[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            int mid = (i + j) / 2;
            if (array[mid] <= array[mid + 1] && array[mid] < array[mid - 1]) {
                return array.length - mid;
            }

            if (array[mid] > array[j]) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return array.length - i;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
        System.out.println(search(new int[] { 2, 2, 6, 7, 0, 1, 2 }));
        System.out.println(search(new int[] { 2, 2, 6, 0, 1, 2, 2 }));
        System.out.println(search(new int[] { 2, 2, 2, 2 }));
    }
}
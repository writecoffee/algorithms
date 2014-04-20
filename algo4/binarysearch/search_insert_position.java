public class search_insert_position {
    public int searchInsert(int[] array, int target) {
        int l = 0;
        int r = array.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}
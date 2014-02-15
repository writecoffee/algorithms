public class search_insert_position {

    public int searchInsert(int[] A, int target) {
        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
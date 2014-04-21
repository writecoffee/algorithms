public class search_the_first_larger_than_target {
    public int search(int[] array, int target) {
        int n = array.length;
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l == n ? -1 : l;
    }
}
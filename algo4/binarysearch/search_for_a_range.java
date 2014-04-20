public class search_for_a_range {
    public int[] searchRange(int[] array, int target) {
        int[] range = { -1, -1 };
        int n = array.length;

        int lower = getLowerBound(array, n, target);
        int upper = getUpperBound(array, n, target);

        if (lower <= upper) {
            range[0] = lower;
            range[1] = upper;
        }

        return range;
    }

    private int getLowerBound(int[] array, int n, int target) {
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (array[mid] == target) {
                r = mid - 1;
            } else if (array[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private int getUpperBound(int[] array, int n, int target) {
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (array[mid] == target) {
                l = mid + 1;
            } else if (array[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;
    }
}
public class find_any_duplicate_number {
    /**
     * There are n numbers in an unsorted array ranging from 1 to n. Find any
     * duplicate number in the array.
     * 
     * The time complexity will be O(n log n) and we should not modify the any
     * element in the array.
     * 
     */
    int search(int[] array, int n) {
        return explore(array, 1, n);
    }

    int explore(int[] array, int l, int r) {
        int lc = 0, rc = 0;
        int mid = l + (r - l) / 2;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= l && array[i] <= mid) {
                lc++;
            } else {
                rc++;
            }
        }

        if (l == r) {
            return lc > 1 ? l : -1;
        } else if (lc == rc) {
            int lr = explore(array, l, mid);
            return lr > 0 ? lr : explore(array, mid + 1, r);
        } else if (lc > rc) {
            return explore(array, l, mid);
        } else {
            return explore(array, mid + 1, r);
        }
    }
}
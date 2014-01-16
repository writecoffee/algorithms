public class search_in_rotated_sorted_array {

    static int search(int[] A, int target) {
        int n = A.length;
        int i = 0;
        int j = n - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            if (A[mid] == target) {
                return mid;
            }

            if (A[i] <= A[mid]) {
                if (A[i] <= target && target < A[mid]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (A[mid] < target && target <= A[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(search(new int[] { 2, 2, 6, 7, 0, 1, 2 }, 2));
    }
}
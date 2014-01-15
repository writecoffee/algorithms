public class remove_duplicates_from_sorted_array {

    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return 1;
        }

        int p = 0;
        int q = 1;
        while (q < A.length && p < A.length) {
            if (A[p] == A[q]) {
                q++;
            } else {
                A[++p] = A[q];
            }
        }

        return p + 1;
    }

    public static void main(String[] args) {

    }
}
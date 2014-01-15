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

    public int removeDuplicatesImprov(int[] A) {
        int n = A.length;
        int j = 0;

        for (int i = 0; i < n; ++i) {
            if (i == 0 || A[i] != A[i - 1]) {
                A[j++] = A[i];
            }
        }

        return j;
    }

    public static void main(String[] args) {

    }
}
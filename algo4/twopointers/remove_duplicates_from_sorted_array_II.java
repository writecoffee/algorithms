public class remove_duplicates_from_sorted_array_II {

    public int removeDuplicates(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        if (A.length == 1) {
            return 1;
        }

        int p = 0;
        int q = 1;
        int count = 0;

        while (q < A.length) {
            if (A[p] == A[q]) {
                count++;
                if (count < 2) {
                    A[++p] = A[q];
                }
            } else {
                A[++p] = A[q];
                count = 0;
            }
            q++;
        }

        return p + 1;
    }

    public static int removeDuplicatesImprov(int[] A) {
        int n = A.length;
        if (n <= 2) {
            return n;
        }

        int j = 2;
        for (int i = 2; i < n; ++i) {
            if (!(A[i] == A[j - 1] && A[i] == A[j - 2])) {
                A[j++] = A[i];
            }
        }

        return j;
    }

    public static void main(String[] args) {
        removeDuplicatesImprov(new int[] { 1, 1, 1, 2, 2, 3 });
    }
}
public class merge_sorted_array {
    public void merge(int[] A, int m, int[] B, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            while (--n >= 0) {
                A[n] = B[n];
            }
        }

        int p = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (p >= 0) {
            if (j < 0) {
                break;
            }
            if (i < 0) {
                while (j >= 0) {
                    A[j] = B[j--];
                }
                break;
            }

            A[p--] = A[i] > B[j] ? A[i--] : B[j--];
        }
    }

    public static void main(String[] args) {

    }
}
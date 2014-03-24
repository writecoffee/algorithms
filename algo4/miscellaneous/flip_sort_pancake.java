public class flip_sort_pancake {
    public static void flipSort(int[] A) {
        for (int i = A.length - 1; i >= 0; i--) {
            int iMax = i;
            for (int j = 0; j < i; ++j) {
                if (A[j] > A[iMax]) {
                    iMax = j;
                }
            }

            if (iMax == i) {
                continue;
            }

            if (iMax == 0) {
                flip(A, 0, i + 1);
            } else {
                flip(A, 0, iMax + 1);
                flip(A, 0, i + 1);
            }
        }
    }

    public static void flip(int[] A, int start, int end) {
        int i = start;
        int j = end - 1;
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] { 1, 2, 10, 7, 8, 3 };
        flipSort(A);
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
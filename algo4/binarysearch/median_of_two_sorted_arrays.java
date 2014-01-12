import java.util.List;
import java.util.ArrayList;

public class median_of_two_sorted_arrays {

    static double findMedianSortedArrays(int[] A, int[] B) {
        int totalLength = A.length + B.length;

        ArrayList<Integer> arrayA = new ArrayList<Integer>();
        ArrayList<Integer> arrayB = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            arrayA.add(A[i]);
        }

        for (int i = 0; i < B.length; i++) {
            arrayB.add(B[i]);
        }

        if ((totalLength & 0x1) > 0) {
            return findKthInSortedArrays(arrayA, arrayB, totalLength / 2 + 1);
        } else {
            return (findKthInSortedArrays(arrayA, arrayB, totalLength / 2) +
                    findKthInSortedArrays(arrayA, arrayB, totalLength / 2 + 1)) / 2;
        }
    }

    private static double findKthInSortedArrays(List<Integer> A, List<Integer> B, int k) {
        int n = A.size();
        int m = B.size();

        if (n == 0) {
            return B.get(k - 1);
        }

        if (m == 0) {
            return A.get(k - 1);
        }

        if (k == 1) {
            return Math.min(A.get(0), B.get(0));
        }

        if (B.get(m / 2) >= A.get(n / 2)) {
            if ((n / 2 + 1 + m / 2) >= k) {
                return findKthInSortedArrays(A, B.subList(0, m / 2), k);
            } else {
                return findKthInSortedArrays(A.subList(n / 2 + 1, n), B, k - (n / 2 + 1));
            }
        } else {
            if ((m /2 + 1 + n / 2) >= k) {
                return findKthInSortedArrays(A.subList(0, n / 2), B, k);
            } else {
                return findKthInSortedArrays(A, B.subList(m / 2 + 1, m), k - (m / 2 + 1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 100000 }, new int[] { 100001 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 3, 4 }, new int[] { 1, 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 5, 6, 7 }, new int[] { 2, 3, 4, 8 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 8, 9, 10 }));
        System.out.println(findMedianSortedArrays(new int[] { 4 }, new int[] { 1, 2, 3 }));
    }
}
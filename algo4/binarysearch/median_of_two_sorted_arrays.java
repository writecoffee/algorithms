public class median_of_two_sorted_arrays {
    static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if ((m + n) % 2 == 1) {
            return findMedianSortedArraysSub(A, 0, m, B, 0, n, (m + n - 1) / 2);
        } else {
            return (findMedianSortedArraysSub(A, 0, m, B, 0, n, (m + n - 1) / 2)
                  + findMedianSortedArraysSub(A, 0, m, B, 0, n, (m + n) / 2)) / 2;
        }
    }

    private static double findMedianSortedArraysSub(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
        int m = aEnd - aStart;
        int n = bEnd - bStart;
        int aMid = aStart + m / 2;
        int bMid = bStart + n / 2;

        if (m == 0) {
            return B[k];
        } else if (n == 0) {
            return A[k];
        }

        if (k == 0) {
            return A[0] > B[0] ? B[0] : A[0];
        }

        if (B[bMid] >= A[aMid]) {
            if (k <= (n / 2 + m / 2)) {
                return findMedianSortedArraysSub(A, aStart, aEnd, B, bStart, bMid, k);
            } else {
                return findMedianSortedArraysSub(A, aMid + 1, aEnd, B, bStart, bEnd, k - (m / 2 + 1));
            }
        } else {
            if (k <= (n / 2 + m / 2)) {
                return findMedianSortedArraysSub(A, aStart, aMid, B, bStart, bEnd, k);
            } else {
                return findMedianSortedArraysSub(A, aStart, aEnd, B, bMid + 1, bEnd, k - (n / 2 + 1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 100000 }, new int[] { 100001 }));
        System.out.println(findMedianSortedArrays(new int[] { 3, 4 }, new int[] { 1, 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 5, 6, 7 }, new int[] { 2, 3, 4, 8 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 8, 9, 10 }));
        System.out.println(findMedianSortedArrays(new int[] { 4 }, new int[] { 1, 2, 3 }));
    }
}
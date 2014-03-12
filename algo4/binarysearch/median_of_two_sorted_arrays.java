public class median_of_two_sorted_arrays {
    static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;

        if (((m + n) & 0x1) == 1) {
            return findMedianSortedArraysSub(A, 0, m, B, 0, n, (m + n) / 2 + 1);
        } else {
            return (findMedianSortedArraysSub(A, 0, m, B, 0, n, (m + n) / 2)
                  + findMedianSortedArraysSub(A, 0, m, B, 0, n, (m + n) / 2 + 1)) / 2;
        }
    }

    private static double findMedianSortedArraysSub(int[] A, int aStart, int aEnd, int[] B, int bStart, int bEnd, int k) {
        int m = aEnd - aStart;
        int n = bEnd - bStart;

        if (m > n) {
            return findMedianSortedArraysSub(B, bStart, bEnd, A, aStart, aEnd, k);
        }

        if (m == 0) {
            return B[k - 1];
        }

        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        int i = Math.min(k / 2, m);
        int j = k - i;
        int a = A[aStart + i - 1];
        int b = B[bStart + j - 1];

        if (a < b) {
            return findMedianSortedArraysSub(A, aStart + i, aEnd, B, bStart, bEnd, k - i);
        } else {
            return findMedianSortedArraysSub(A, aStart, aEnd, B, bStart + j, bEnd, k - j);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { }, new int[] { 1 }));
        System.out.println(findMedianSortedArrays(new int[] { 100000 }, new int[] { 100001 }));
        System.out.println(findMedianSortedArrays(new int[] { 3, 4 }, new int[] { 1, 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 1, 2 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 5, 6, 7 }, new int[] { 2, 3, 4, 8 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 3, 4 }, new int[] { 5, 6, 7, 8, 9, 10 }));
        System.out.println(findMedianSortedArrays(new int[] { 4 }, new int[] { 1, 2, 3 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 2 }, new int[] { 1, 2, 3 }));
        System.out.println(findMedianSortedArrays(new int[] { 1 }, new int[] { 2, 3, 4, 5, 6 }));
    }
}
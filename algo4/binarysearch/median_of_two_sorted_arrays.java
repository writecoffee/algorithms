public class median_of_two_sorted_arrays {
    static double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;

        if (((m + n) & 0x1) == 1) {
            return explore(a, 0, m, b, 0, n, (m + n) / 2 + 1);
        } else {
            return (explore(a, 0, m, b, 0, n, (m + n) / 2)
                  + explore(a, 0, m, b, 0, n, (m + n) / 2 + 1)) / 2;
        }
    }

    private static double explore(int[] a, int ai, int aj, int[] b, int bi, int bj, int k) {
        int m = aj - ai;
        int n = bj - bi;

        if (m > n) {
            return explore(b, bi, bj, a, ai, aj, k);
        } else if (m == 0) {
            return b[k - 1];
        } else if (k == 1) {
            return Math.min(a[ai], b[bi]);
        }

        int aMid = Math.min(k / 2, m);
        int bMid = k - aMid;

        if (a[ai + aMid - 1] < b[bi + bMid - 1]) {
            return explore(a, ai + aMid, aj, b, bi, bj, k - aMid);
        } else {
            return explore(a, ai, aj, b, bi + bMid, bj, k - bMid);
        }
    }
}
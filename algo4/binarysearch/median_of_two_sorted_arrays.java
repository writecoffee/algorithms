/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 * 
 * [Difficulty] - Hard
 * [Source]     - {@linkplain https://leetcode.com/problems/median-of-two-sorted-arrays/}
 *
 */
public class median_of_two_sorted_arrays
{
    public double findMedianSortedArrays(int[] a, int[] b)
    {
        int m = a.length;
        int n = b.length;

        if (((m + n) & 0x1) == 1) {
            return explore(a, 0, m - 1, b, 0, n - 1, (m + n) / 2 + 1);
        } else {
            return (explore(a, 0, m - 1, b, 0, n - 1, (m + n) / 2)
                  + explore(a, 0, m - 1, b, 0, n - 1, (m + n) / 2 + 1)) / 2;
        }
    }

    private double explore(int[] a, int al, int ar, int[] b, int bl, int br, int k)
    {
        int m = ar - al + 1;
        int n = br - bl + 1;

        if (m > n) {
            return explore(b, bl, br, a, al, ar, k);
        } else if (m == 0) {
            return b[k - 1];
        } else if (k == 1) {
            return Math.min(a[al], b[bl]);
        }

        int aMid = Math.min(k / 2, m);
        int bMid = k - aMid;

        if (a[al + aMid - 1] < b[bl + bMid - 1]) {
            return explore(a, al + aMid, ar, b, bl, br, k - aMid);
        } else {
            return explore(a, al, ar, b, bl + bMid, br, k - bMid);
        }
    }

    public double findMedianSortedArraysNonrecur(int[] a, int[] b)
    {
        int m = a.length;
        int n = b.length;

        if (((m + n) & 0x1) == 1) {
            return getKthNumber(m < n ? a : b, m < n ? b : a, (m + n) / 2 + 1);
        } else {
            return (getKthNumber(m < n ? a : b, m < n ? b : a, (m + n) / 2)
                  + getKthNumber(m < n ? a : b, m < n ? b : a, (m + n) / 2 + 1)) / 2;
        }
    }

    private double getKthNumber(int[] a, int[] b, int k)
    {
        int m = a.length;
        int n = b.length;
        int al = 0, ar = m - 1;
        int bl = 0, br = n - 1;

        while (m > 0 && k != 1) {
            int aMid = Math.min(k / 2, m);
            int bMid = k - aMid;

            if (a[al + aMid - 1] < b[bl + bMid - 1]) {
                al = al + aMid;
                k = k - aMid;
                m = ar - al + 1;
            } else {
                bl = bl + bMid;
                k = k - bMid;
                n = br - bl + 1;
            }

            if (n < m) {
                int[] tmp = a;
                a = b;
                b = tmp;
                int lTmp = al;
                al = bl;
                bl = lTmp;
                int rTmp = ar;
                ar = br;
                br = rTmp;
                m = ar - al + 1;
                n = br - bl + 1;
            }
        }

        if (m == 0) {
            return b[bl + k - 1];
        } else {
            return Math.min(a[al], b[bl]);
        }
    }
}
package presum;

/**
 * Given an integer array, find a subarray where the sum of numbers is between
 * two given interval. Your code should return the number of possible answer.
 * (The element in the array should be positive)
 *
 * Example Given [1,2,3,4] and interval = [1,3], return 4. The possible answers
 * are:
 *
 * [0, 0] [0, 1] [1, 1] [2, 2]
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/subarray-sum-ii/}
 * [Difficulty] - Hard
 *
 */
public class arr_ps_subarray_sum_II
{
    public int subarraySumII(int[] A, int start, int end)
    {
        int n = A.length;
        int[] subSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            subSum[i + 1] = subSum[i] + A[i];
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int si = subSum[i];
            int lb = si - end;
            int rb = si - start;

            int lbindex = searchLb(subSum, 0, i, lb);
            int rbindex = searchRb(subSum, 0, i, rb);

            if (lbindex <= rbindex) {
                result += rbindex + 1 - lbindex;
            }
        }

        return result;
    }

    int searchLb(int[] A, int start, int end, int target)
    {
        int l = start, r = end - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = A[mid];

            if (midVal >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    int searchRb(int[] A, int start, int end, int target)
    {
        int l = start, r = end - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = A[mid];

            if (midVal <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return r;
    }
}

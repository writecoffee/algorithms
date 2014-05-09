package gmax;

public class maximum_sub_array {
    public int maxSubArray(int[] A) {
        int globalMaxSum = A[0];
        int localMaxSum = A[0];
        for (int i = 1; i < A.length; i++) {
            localMaxSum = Math.max(A[i], localMaxSum + A[i]);
            globalMaxSum = Math.max(localMaxSum, globalMaxSum);
        }

        return globalMaxSum;
    }

    public int[] maxSubArrayWithIndices(int[] A) {
        int globalMaxSum = A[0];
        int localMaxSum = A[0];
        int start = 0;
        int startTemp = 0;
        int end = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > localMaxSum + A[i]) {
                localMaxSum = A[i];
                startTemp = i;
            } else {
                localMaxSum = localMaxSum + A[i];
            }

            if (localMaxSum > globalMaxSum) {
                globalMaxSum = localMaxSum;
                start = startTemp;
                end = i;
            }
        }

        return new int[] { globalMaxSum, start, end };
    }

    public int maxSubArrayLength(int[] A) {
        int gMaxSum = A[0];
        int lMaxSum = A[0];
        int len = 1;
        int j = 0;

        for (int i = 1; i < A.length; i++) {
            if (lMaxSum < 0) {
                lMaxSum = A[i];
                j = i;
            } else {
                lMaxSum += A[i];
            }

            if (lMaxSum > gMaxSum) {
                len = i - j + 1;
                gMaxSum = lMaxSum;
            }
        }

        return len;
    }

    /**
     * A variance of this problem: if the maximum sum is negative, return 0. 
     * 
     */
    public int maxConsSum(int[] arr) {
        int n = arr.length;

        int lMax = arr[0];
        int gMax = arr[0];

        for (int i = 1; i < n; ++i) {
            lMax += arr[i];
            lMax = Math.max(0, lMax);
            gMax = Math.max(gMax, lMax);
        }

        return Math.max(0, gMax);
    }

    /**
     * A variance of this problem: if the array represents a circle.
     * This solution uses two arrays to store maximum sum for arr[0 .. i]
     * and arr[i .. n - 1].
     */
    public int maxConsSumInCircle(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int gMax = maxConsSum(arr);

        int[] l2r = new int[n];
        int[] r2l = new int[n];

        l2r[0] = Math.max(0, arr[0]);
        int sum = arr[0];
        for (int i = 1; i < n; ++i) {
            sum += arr[i];
            l2r[i] = Math.max(l2r[i - 1], sum);
        }

        r2l[n - 1] = Math.max(0, arr[n - 1]);
        sum = arr[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            sum += arr[i];
            r2l[i] = Math.max(r2l[i + 1], sum);
        }

        for (int i = 0; i < n - 1; ++i) {
            gMax = Math.max(gMax, l2r[i] + r2l[i + 1]);
        }

        return gMax;
    }
}
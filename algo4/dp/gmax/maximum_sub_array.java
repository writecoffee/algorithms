package gmax;

public class maximum_sub_array {

    public static int maxSubArray(int[] A) {
        int globalMaxSum = A[0];
        int localMaxSum = A[0];
        for (int i = 1; i < A.length; i++) {
            localMaxSum = Math.max(A[i], localMaxSum + A[i]);
            globalMaxSum = Math.max(localMaxSum, globalMaxSum);
        }

        return globalMaxSum;
    }

    public static int[] maxSubArrayWithIndices(int[] A) {
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

    public static int maxSubArrayLength(int[] A) {
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
    public static int maxConsSum(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int lMax = 0;
        int gMax = 0;

        for (int i = 0; i < n; ++i) {
            lMax += arr[i];

            if (lMax < 0) {
                lMax = 0;
                continue;
            }

            gMax = lMax > gMax ? lMax : gMax;
        }

        return gMax;
    }

    /**
     * A variance of this problem: if the array represents a circle.
     * This solution uses two arrays to store maximum sum for arr[0 .. i]
     * and arr[i .. n - 1].
     */
    public static int maxConsSumInCircle(int[] arr) {
        int n = arr.length;
        if (n == 0) {
            return 0;
        }

        int nMax = maxConsSum(arr);

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
            nMax = Math.max(nMax, l2r[i] + r2l[i + 1]);
        }

        return nMax;
    }

    public static void main(String[] args) {
        System.out.println("Max Sum: " + maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println("Sum Len: " + maxSubArrayLength(new int[] { -1, -1, -1, 4, -1, 2, 1, -5, 4 }));

        maxSubArrayWithIndices(new int[] { -1, -1, -1, 4, -1, 2, 1, -5, 4 });
        maxSubArrayWithIndices(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });

        System.out.println(maxConsSumInCircle(new int[] { 1, 2, -3, 4, -1, 0, 2 }));
        System.out.println(maxConsSumInCircle(new int[] { 1, -2, 100, -1, 2, -3 }));
        

    }
}
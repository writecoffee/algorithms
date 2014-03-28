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
     */
    public int maxConsSum(int[] arr) {
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

    public static void main(String[] args) {
        System.out.println("Max Sum: " + maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        System.out.println("Sum Len: " + maxSubArrayLength(new int[] { -1, -1, -1, 4, -1, 2, 1, -5, 4 }));

        maxSubArrayWithIndices(new int[] { -1, -1, -1, 4, -1, 2, 1, -5, 4 });
        maxSubArrayWithIndices(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 });
    }
}
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

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        maxSubArrayWithIndices(new int[] { -1, -1, -1, 4, -1, 2, 1, -5, 4 });
    }
}
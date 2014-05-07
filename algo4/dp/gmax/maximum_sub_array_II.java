public class maximum_sub_array_II {

    public static int maxSubArray(int[] A) {
        int localMax = 1;
        int localMin = 1;
        int globalMax = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                localMax = localMax * A[i];
                localMin = localMin * A[i];
            } else if (A[i] == 0) {
                localMax = 1;
                localMin = 1;
            } else {
                int temp = localMax;
                localMax = Math.max(localMin * A[i], 1);
                localMin = temp * A[i];
            }

            globalMax = globalMax < localMax ? localMax : globalMax;
        }

        return globalMax;
    }

    public static int[] maxSubArrayWithIndices(int[] A) {
        assert A.length > 0;

        int localMax = 1;
        int localMin = 1;
        int globalMax = Integer.MIN_VALUE;
        int start = 0;
        int tempStart = 0;
        int endInclusive = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                localMax = localMax * A[i];
                localMin = localMin * A[i];
            } else if (A[i] == 0) {
                localMin = 1;
                localMax = 1;
                tempStart = i + 1;
            } else {
                int temp = localMax;
                
                if (localMin * A[i] < 1) {
                    localMax = 1;
                } else {
                    localMax = localMin * A[i];
                }

                localMin = temp * A[i];
            }

            if (globalMax < localMax) {
                endInclusive = i;
                start = tempStart;
                globalMax = localMax;
            }
        }

        return new int[] { start, endInclusive, globalMax };
    }

    public static void main(String[] args) {
        assert maxSubArray(new int[] { -2, 3, 0, -2, -40 }) == 80;
        assert maxSubArray(new int[] { 1, -2, -3, 0, 7, -8, -2 }) == 112;
        assert maxSubArray(new int[] { -1, -3, -10, 0, 60 }) == 60;
        assert maxSubArray(new int[] { 6, -3, -10, 0, 2 }) == 180;
        assert maxSubArray(new int[] { -1, -1, -10, 4, -1, 2, 1, -5, 4 }) == 1600;
        assert maxSubArray(new int[] { -1, -1, -10, 4, -1, 2, 1, -5, 4, -1 }) == 1600;

        int[] result = maxSubArrayWithIndices(new int[] { -1, -1, -1, -10, 4, -1, 2, 1, -5, -3 });
        assert result[0] == 1;      // FAILED!!
        assert result[1] == 9;
        assert result[2] == 1600;

        result = maxSubArrayWithIndices(new int[] { -1, 3, 3, -1});
        assert result[0] == 1;
        assert result[1] == 2;
        assert result[2] == 9;

        result = maxSubArrayWithIndices(new int[] { 3, 3, 1 });
        assert result[0] == 0;
        assert result[1] == 1;
        assert result[2] == 9;
    }
}
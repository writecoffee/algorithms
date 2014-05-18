package basic;

public class dp_non_consecutive_color_housing_printing_with_minimum_cost {
    static int calculate(int[][] A) {
        assert A.length > 0 && A[0].length > 0;

        int m = A.length;
        int n = A[0].length;

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = A[0][i];
        }

        for (int i = 1; i < m; i++) {
            int[] temp = new int[n];

            for (int j = 0; j < n; j++) {
                temp[j] = A[i][j] + pollMin(dp, j);
            }

            dp = temp;
        }

        return pollMin(dp, 0);
    }

    public static int pollMin(int[] A, int except) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (i != except && A[i] < min) {
                min = A[i];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] A = new int[][] {
                        { 1, 5, 3, 9, 2 },
                        { 2, 3, 4, 5, 7 },
                        { 2, 3, 4, 9, 5 } };

        System.out.println(calculate(A));
    }
}
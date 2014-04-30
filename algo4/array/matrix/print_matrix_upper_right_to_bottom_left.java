package matrix;

import java.util.ArrayList;

public class print_matrix_upper_right_to_bottom_left {
    public static ArrayList<Integer> printArray(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int m = matrix.length;
        int n = matrix[0].length;
        int k = m + n - 1;

        for (int i = 0; i < k; ++i) {
            for (int row = i < n ? 0 : i - n + 1, col = n - i > 0 ? n - i - 1 : 0; row < m && col < n; ++row, ++col) {
                result.add(matrix[row][col]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] A = new int[][] {
                        { 2, 3, 1 },
                        { 4, 7, 4 },
                        { 9, -1, 3}
        };

        int[][] B = new int[][] {
                        { 7, 7, 2, 4},
                        { 0, 1, 2, 3}
        };

        for (int val : printArray(A)) {
            System.out.print(val + " ");
        }
        System.out.println();

        for (int val : printArray(B)) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
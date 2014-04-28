import java.util.ArrayList;

public class print_matrix_upper_right_to_bottom_left {
    public static ArrayList<Integer> printArray(int[][] A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int k = A.length + A[0].length - 1;
        int m = A.length;
        int n = A[0].length;

        for (int i = 0, diff = n - 1; i < k; i++, diff--) {
            for (int row = Math.max(0, i - (n - 1)), col = row + diff; row < m && col < n; row++, col++) {
                result.add(A[row][col]);
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
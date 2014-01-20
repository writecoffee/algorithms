public class search_a_2d_matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = m * n - 1;

        while (i <= j) {
            int mid = (i + j) / 2;
            int midRow = mid / n;
            int midCol = mid % n;
            if (matrix[midRow][midCol] == target) {
                return true;
            } else if (matrix[midRow][midCol] < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
public class search_in_a_sorted_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
}
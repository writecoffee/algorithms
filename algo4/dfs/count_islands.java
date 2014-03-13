public class count_islands {
    public static int countIslands(int[][] A) {
        int count = 0;
        int m = A.length;
        int n = A[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (countHelper(A, i, j) > 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countHelper(int[][] A, int startRow, int startCol) {
        if (startCol < 0
         || startRow < 0
         || startRow >= A.length
         || startCol >= A[0].length
         || A[startRow][startCol] == 0) {
            return 0;
        }

        A[startRow][startCol] = 0;

        return countHelper(A, startRow + 1, startCol) +
               countHelper(A, startRow, startCol + 1) +
               countHelper(A, startRow - 1, startCol) +
               countHelper(A, startRow , startCol - 1) + 1;
    }

    public static void main(String[] args) {
        System.out.println(countIslands(new int[][] {
                        { 1, 1, 1, 0, 0 },
                        { 0, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 0 }
        }));
        System.out.println(countIslands(new int[][] {
                        { 1, 0, 1 },
                        { 0, 1, 0 },
                        { 1, 0, 1 }
        }));
    }
}
public class n_queens_counter {
    public int totalNQueens(int n) {
        return explore(n, 0, 0, 0, 0);
    }

    private int explore(int n, int i, int colMask, int ldMask, int rdMask) {
        if (i == n) {
            return 1;
        }

        int result = 0;
        int mask = colMask | ldMask | rdMask;

        for (int j = 0; j < n; ++j) {
            int p = 1 << j;

            if ((p & mask) == 0) {
                result += explore(n, i + 1, p | colMask, (p | ldMask) << 1, (p | rdMask) >> 1);
            }
        }

        return result;
    }
}

public class n_queens_counter {
    public int totalNQueens(int n) {
        return probe(n, 0, 0, 0);
    }

    private int probe(int n, int bitsCols, int bitsLds, int bitsRds) {
        if (bitsCols == (1 << n) - 1) {
            return 1;
        }

        int result = 0;
        int bitsAvailable = ~(bitsCols | bitsLds | bitsRds);
        for (int i = 0; i < n; i++) {
            int bCol = 1 << i;
            if ((bCol & bitsAvailable) != 0) {
                result += probe(n, bitsCols | bCol, (bitsLds | bCol) << 1, (bitsRds | bCol) >> 1);
            }
        }

        return result;
    }
}
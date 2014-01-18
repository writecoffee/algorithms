public class n_queens_II {

    public static int totalNQueens(int n) {
        return probe(n, 0, 0, 0);
    }

    public static int probe(int n, int bitsRows, int bitsLds, int bitsRds) {
        if (bitsRows == (1 << n) - 1) {
            return 1;
        }

        int result = 0;
        int bitsAvailable = ~(bitsRows | bitsLds | bitsRds);
        for (int i = 0; i < n; i++) {
            int pos = 1 << i;
            if ((pos & bitsAvailable) != 0) {
                result += probe(n, bitsRows | pos, (bitsLds | pos) << 1, (bitsRds | pos) >> 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
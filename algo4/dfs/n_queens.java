import java.util.ArrayList;

public class n_queens {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            row.append('.');
        }

        explore(row, n, 0, 0, 0, new ArrayList<String>(), result);
        return result;
    }

    private void explore(StringBuilder cleanRow, int n, int bitsCols, int bitsLds, int bitsRds, ArrayList<String> c, ArrayList<String[]> result) {
        /**
         * It could also be terminated using a "depth" parameter.
         */
        if (bitsCols == (1 << n) - 1) {
            result.add(c.toArray(new String[n]));
            return;
        }

        int bitsAvailable = ~(bitsCols | bitsLds | bitsRds);
        for (int i = 0; i < n; ++i) {
            int bCol = 1 << i;
            if ((bitsAvailable & bCol) != 0) {
                cleanRow.setCharAt(i, 'Q');
                c.add(cleanRow.toString());
                cleanRow.setCharAt(i, '.');
                explore(cleanRow, n, bitsCols | bCol, (bitsLds | bCol) << 1, (bitsRds | bCol) >> 1, c, result);
                c.remove(c.size() - 1);
            }
        }
    }
}
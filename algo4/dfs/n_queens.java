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

    private void explore(StringBuilder clearRow, int n, int bitsRows, int bitsLds, int bitsRds, ArrayList<String> c, ArrayList<String[]> result) {
        if (bitsRows == (1 << n) - 1) {
            result.add(c.toArray(new String[n]));
            return;
        }

        int bitsAvailable = ~(bitsRows | bitsLds | bitsRds);
        for (int i = 0; i < n; ++i) {
            int col = 1 << i;
            if ((bitsAvailable & col) != 0) {
                clearRow.setCharAt(i, 'Q');
                c.add(clearRow.toString());
                clearRow.setCharAt(i, '.');
                explore(clearRow, n, bitsRows | col, (bitsLds | col) << 1, (bitsRds | col) >> 1, c,
                                result);
                c.remove(c.size() - 1);
            }
        }
    }
}
import java.util.ArrayList;

public class n_queens {

    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        ArrayList<String> intermediate = new ArrayList<String>();
        StringBuilder s = new StringBuilder();
        for (int j = 0; j < n; ++j) {
            s.append('.');
        }

        probe(s, n, 0, 0, 0, intermediate, result);
        return result;
    }

    private static void probe(
                    StringBuilder s,
                    int n,
                    int bitsRows,
                    int bitsLds,
                    int bitsRds,
                    ArrayList<String> intermediate,
                    ArrayList<String[]> result) {

        if (bitsRows == (1 << n) - 1) {
            result.add(intermediate.toArray(new String[intermediate.size()]));
            return;
        }

        int bitsAvailable = ~(bitsRows | bitsLds | bitsRds);
        for (int i = 0; i < n; ++i) {
            int pos = 1 << i;

            if ((bitsAvailable & pos) != 0) {
                s.setCharAt(i, 'Q');
                intermediate.add(s.toString());
                s.setCharAt(i, '.');

                probe(s, n, bitsRows | pos, (bitsLds | pos) << 1, (bitsRds | pos) >> 1, intermediate, result);
                intermediate.remove(intermediate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        solveNQueens(8);
    }
}
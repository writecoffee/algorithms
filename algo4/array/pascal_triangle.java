import java.util.ArrayList;

public class pascal_triangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows < 1) {
            return result;
        }

        ArrayList<Integer> newRow = new ArrayList<Integer>();
        newRow.add(1);
        result.add(newRow);
        for (int i = 1, k = numRows - 2; i < numRows; i++, k--) {
            ArrayList<Integer> preRow = result.get(i - 1);
            ArrayList<Integer> row = new ArrayList<Integer>(newRow);
            for (int j = 1; j < numRows - k - 1; j++) {
                row.add(preRow.get(j - 1) + preRow.get(j));
            }
            row.add(1);
            result.add(row);
        }

        return result;
    }
}
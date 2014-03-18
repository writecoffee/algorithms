import java.util.ArrayList;

public class pascal_triangle_II {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> pre;
        ArrayList<Integer> result = new ArrayList<Integer>();

        result.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            result.add(0);
        }

        for (int i = 1, k = rowIndex - 1; i <= rowIndex; i++, k--) {
            pre = new ArrayList<Integer>(result);
            for (int j = 1; j <= rowIndex - k; ++j) {
                result.set(j, pre.get(j - 1) + pre.get(j));
            }
        }

        return result;
    }
}
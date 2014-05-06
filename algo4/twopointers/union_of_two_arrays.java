import java.util.ArrayList;

public class union_of_two_arrays {
    public int[] arrayUnion(int[] a, int[] b) {
        int m = a.length, n = b.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;

        while (i < m || j < n) {
            if (i > 0 && i < m && a[i] == a[i - 1]) {
                i++;
                continue;
            } else if (j > 0 && j < n && b[j] == b[j - 1]) {
                j++;
                continue;
            }

            int aVal = i >= m ? b[j] : a[i];
            int bVal = j >= n ? a[i] : b[j];

            if (aVal < bVal) {
                result.add(aVal);
                i++;
            } else if (aVal > bVal) {
                result.add(bVal);
                j++;
            } else {
                result.add(aVal);

                i++;
                j++;
            }
        }

        return convert(result);
    }

    private int[] convert(ArrayList<Integer> result) {
        int[] array = new int[result.size()];

        for (int i = 0; i < result.size(); ++i) {
            array[i] = result.get(i);
        }

        return array;
    }
}
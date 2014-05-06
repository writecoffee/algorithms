import java.util.ArrayList;

public class intersection_of_two_arrays {
    public int[] arrayIntersect(int[] a, int[] b) {
        int m = a.length, n = b.length;
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            int aVal = a[i], bVal = b[j];

            if (aVal < bVal) {
                i++;
            } else if (aVal > bVal) {
                j++;
            } else if (i > 0 && aVal == a[i - 1]) {
                i++;
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
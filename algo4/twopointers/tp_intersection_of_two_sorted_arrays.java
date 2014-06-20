import java.util.ArrayList;

/**
 * There are two sorted arrays in ascending order, compute the intersection of these two arrays
 * while remaining order. The result shouldn't have duplicate values.
 * 
 * [Difficulty] - Medium
 * [Source]     - facebook interview, {@linkplain http://www.itint5.com/oj/#43}
 * 
 */
public class tp_intersection_of_two_sorted_arrays {
    public int[] arrayIntersect(int[] array1, int[] array2) {
        int m = array1.length, n = array2.length;
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0, j = 0; i < m && j < n;) {
            if (array1[i] < array2[j]) {
                i++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                appendValue(result, array1[i++]);
                j++;
            }
        }

        return convert(result);
    }

    private void appendValue(ArrayList<Integer> result, int val) {
        if (result.isEmpty() || result.get(result.size() - 1) < val) {
            result.add(val);
        }
    }

    private int[] convert(ArrayList<Integer> result) {
        int[] array = new int[result.size()];

        for (int i = 0; i < result.size(); ++i) {
            array[i] = result.get(i);
        }

        return array;
    }
}
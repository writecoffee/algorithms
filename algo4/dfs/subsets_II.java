import java.util.ArrayList;
import java.util.Arrays;

public class subsets_II {
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        int dupCount = 0;
        for (int i = 0; i < num.length; ++i) {
            if (i > 0 && num[i] == num[i - 1]) {
                ++dupCount;
            } else {
                dupCount = 0;
            }

            for (int j = result.size() - 1; j >= 0; --j) {
                ArrayList<Integer> pre = result.get(j);

                /**
                 *  for duplicates, only append to subsets containing ALL PREVIOUS duplicates
                 */
                if (dupCount > 0 && (pre.size() < dupCount || pre.get(pre.size() - dupCount) != num[i])) {
                    continue;
                }

                ArrayList<Integer> res = new ArrayList<Integer>(pre);
                res.add(num[i]);
                result.add(res);
            }
        }

        return result;
    }

    public static ArrayList<ArrayList<Integer>> subsetsWithDupRecur(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        result.add(intermediate);
        Arrays.sort(num);

        subsetsWithDupRecurHelper(num, 0, result, intermediate);
        return result;
    }

    private static void subsetsWithDupRecurHelper(
                    int[] num,
                    int i,
                    ArrayList<ArrayList<Integer>> result,
                    ArrayList<Integer> output) {
 
        if (i >= num.length) {
            return;
        }

        for (int j = i; j < num.length; j++) {
            output.add(num[j]);
            result.add(new ArrayList<Integer>(output));

            subsetsWithDupRecurHelper(num, j + 1, result, output);

            output.remove(output.size() - 1);

            while (j < num.length - 1 && num[j + 1] == num[j]) {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        subsetsWithDup(new int[] { 1, 2, 2, 2 });
        subsetsWithDupRecur(new int[] { 1, 2, 2, 2 });
    }
}
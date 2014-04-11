import java.util.ArrayList;
import java.util.Arrays;

public class generate_subsets {
    public ArrayList<ArrayList<Integer>> generateSubsets(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> emptySet = new ArrayList<Integer>();
        result.add(emptySet);
        Arrays.sort(num);
        explore(num, 0, result, emptySet);
        return result;
    }

    private void explore(int[] num, int i, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> pre) {
        if (i == num.length) {
            return;
        }

        for (int j = i; j < num.length; j++) {
            ArrayList<Integer> nxt = new ArrayList<Integer>(pre);
            nxt.add(num[j]);
            result.add(nxt);
            explore(num, j + 1, result, nxt);
        }
    }

    public ArrayList<ArrayList<Integer>> generateSubsetsNonrecur(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        Arrays.sort(num);

        for (Integer val : num) {
            ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> pre : result) {
                ArrayList<Integer> nxt = new ArrayList<Integer>(pre);
                nxt.add(val);
                t.add(nxt);
            }

            result.addAll(t);
        }

        return result;
    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class generate_subsets_no_duplicate {
    public ArrayList<ArrayList<Integer>> subsetsWithDupNonrecur(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        int dc = 0;
        for (int i = 0; i < num.length; ++i) {
            if (i > 0 && num[i] == num[i - 1]) {
                ++dc;
            } else {
                dc = 0;
            }

            int c = num[i];
            ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> pre : result) {
                if (dc == 0 || (pre.size() >= dc && pre.get(pre.size() - dc) == c)) {
                    ArrayList<Integer> nxt = new ArrayList<Integer>(pre);
                    nxt.add(c);
                    t.add(nxt);
                }
            }

            result.addAll(t);
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> emptySet = new ArrayList<Integer>();
        result.add(new ArrayList<Integer>());
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

            while (j < num.length - 1 && num[j + 1] == num[j]) {
                j++;
            }
        }
    }
}
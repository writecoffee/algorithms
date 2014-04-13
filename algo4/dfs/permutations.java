import java.util.ArrayList;
import java.util.HashSet;

public class permutations {
    public ArrayList<ArrayList<Integer>> permuteNonrecur(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        int n = num.length;

        for (int i = 0; i < n; ++i) {
            ArrayList<ArrayList<Integer>> t = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> pre : result) {
                for (int j = 0; j <= pre.size(); ++j) {
                    ArrayList<Integer> nxt = new ArrayList<Integer>(pre);
                    nxt.add(j, num[i]);
                    t.add(nxt);
                }
            }
            result = t;
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        explore(num, new ArrayList<Integer>(), new HashSet<Integer>(), result);
        return result;
    }

    void explore(int[] num, ArrayList<Integer> nxt, HashSet<Integer> visited, ArrayList<ArrayList<Integer>> result) {
        int n = num.length;
        if (nxt.size() == n) {
            result.add(new ArrayList<Integer>(nxt));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited.contains(num[i])) {
                visited.add(num[i]);
                nxt.add(num[i]);
                explore(num, nxt, visited, result);
                nxt.remove(nxt.size() - 1);
                visited.remove(num[i]);
            }
        }
    }
}
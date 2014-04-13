import java.util.ArrayList;
import java.util.Arrays;

public class permutations_II {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        explore(num, new ArrayList<Integer>(), new boolean[num.length], result);
        return result;
    }

    private void explore(int[] num, ArrayList<Integer> nxt, boolean[] visited, ArrayList<ArrayList<Integer>> result) {
        int n = num.length;
        if (nxt.size() == n) {
            result.add(new ArrayList<Integer>(nxt));
            return;
        }

        int last = -1;
        for (int i = 0; i < n; ++i) {
            if (!visited[i] && (last == -1 || num[i] != num[last])) {
                visited[i] = true;
                nxt.add(num[i]);
                explore(num, nxt, visited, result);
                nxt.remove(nxt.size() - 1);
                visited[i] = false;
                last = i;
            }
        }
    }
}
import java.util.ArrayList;

public class permutations {

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> intermediateResult : result) {
                for (int j = 0; j < intermediateResult.size() + 1; j++) {
                    intermediateResult.add(j, num[i]);
                    temp.add(new ArrayList<Integer>(intermediateResult));
                    intermediateResult.remove(j);
                }
            }

            result = temp;
        }

        return result;
    }
}
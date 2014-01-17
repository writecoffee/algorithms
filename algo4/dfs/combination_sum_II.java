import java.util.ArrayList;
import java.util.Arrays;

public class combination_sum_II {

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> li = new ArrayList<Integer>();
        getList(candidates, target, li, result, 0);
        return result;
    }

    private static void getList(int[] candidates, int target, ArrayList<Integer> intermediate, ArrayList<ArrayList<Integer>> result, int head) {
        if (target == 0) {
            ArrayList<Integer> newResult = new ArrayList<Integer>(intermediate);
            if (!result.contains(newResult)) {
                result.add(newResult);
            }
        }

        for (int i = head; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                intermediate.add(candidates[i]);
                getList(candidates, target - candidates[i], intermediate, result, i + 1);
                intermediate.remove(intermediate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        combinationSum(new int[] { 2 }, 1);
        combinationSum(new int[] { 21, 46, 35, 20, 44, 31, 29, 23, 45, 37, 33, 34, 39, 42, 24, 40, 41, 26, 22, 38, 36, 27, 25, 49, 48, 43 }, 71);
    }
}
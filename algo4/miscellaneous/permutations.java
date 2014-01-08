import java.util.ArrayList;


public class permutations {

    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<Integer> cal = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int len = num.length;
        int[] used = new int[len];

        getPermuatation(num, used, len, cal, result);

        return result;
    }

    public static void getPermuatation(int[] num, int[] used, int len, ArrayList<Integer> cal, ArrayList<ArrayList<Integer>> result) {
        if (cal.size() == len) {
            ArrayList<Integer> copiedResult = new ArrayList<Integer>(cal);
            result.add(copiedResult);
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i] == 0) {
                cal.add(num[i]);
                used[i] = 1;
                getPermuatation(num, used, len, cal, result);
                used[i] = 0;
                cal.remove(cal.size() - 1);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> permuteNonrecur(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            ArrayList<ArrayList<Integer>> currentResult = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> intermediatePerm : result) {
                for (int j = 0; j < intermediatePerm.size() + 1; j++) {
                    intermediatePerm.add(j, num[i]);
                    currentResult.add(new ArrayList<Integer>(intermediatePerm));
                    intermediatePerm.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(currentResult);
        }

        return result;
    }

    public static void main(String[] args) {
        permute(new int[] {1});
        permute(new int[] {1, 2, 3});
        permuteNonrecur(new int[] {1, 2, 3});
    }
}
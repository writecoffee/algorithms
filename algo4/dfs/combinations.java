import java.util.ArrayList;

public class combinations {

    public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<Integer> col = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        probe(n, k, col, result, 0);
        return result;
    }

    public static void probe(int n, int k, ArrayList<Integer> intermediate, ArrayList<ArrayList<Integer>> result, int startupNumber) {
        if (intermediate.size() == k) {
            ArrayList<Integer> t = new ArrayList<Integer>(intermediate);
            result.add(t);
            return;
        }

        for (int i = startupNumber; i < n; i++) {
            intermediate.add(i + 1);
            probe(n, k, intermediate, result, i + 1);
            intermediate.remove(intermediate.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> combineNonrecur(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (k == 0) {
            return result;
        }

        result.add(new ArrayList<Integer>());
        for (int i = 0; i < k; i++) {
            ArrayList<ArrayList<Integer>> nextResult = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> intermediate : result) {
                int nextStartupNumber = 0;
                if (intermediate.size() > 0) {
                    nextStartupNumber = intermediate.get(intermediate.size() - 1);
                }

                for (int j = nextStartupNumber; j < n - (k - i) + 1; j++) {
                    ArrayList<Integer> newIntermediate = new ArrayList<Integer>(intermediate);
                    newIntermediate.add(j + 1);
                    nextResult.add(newIntermediate);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(nextResult);
        }

        return result;
    }

    public static void main(String[] args) {
        combineNonrecur(4, 3);
    }
}
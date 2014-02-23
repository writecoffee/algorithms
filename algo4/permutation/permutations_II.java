import java.util.ArrayList;
import java.util.HashSet;

public class permutations_II {
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();

        if (num.length < 1) {
            return results;
        }

        if (num.length == 1) {
            ArrayList<Integer> perm = new ArrayList<Integer>();
            perm.add(num[0]);
            results.add(perm);
            return results;
        }

        HashSet<Integer> visited = new HashSet<Integer>();

        for (int i = 0; i < num.length; ++i) {
            if (visited.contains(num[i])) {
                continue;
            }

            visited.add(num[i]);

            /**
             * Copy the remainder [0, i), [i + 1, N) of the array to the "subset".
             */
            int[] subset = new int[num.length - 1];
            for (int j = 0; j < i; ++j) {
                subset[j] = num[j];
            }
            for (int j = i + 1; j < num.length; ++j) {
                subset[j - 1] = num[j];
            }

            /**
             * Append the current number to the end of permutations of the "subset".
             */
            for (ArrayList<Integer> perm : permuteUnique(subset)) {
                perm.add(num[i]);
                results.add(perm);
            }
        }

        return results;
    }

    public static void main(String[] args) {
        permuteUnique(new int[] { 1, 1, 2 });
    }
}
import java.util.ArrayList;
import java.util.Arrays;

public class three_sum {
    static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);

        int n = num.length;
        for (int k = 0; k < n - 1; ++k) {
            int iOrig = k + 1, jOrig = n - 1, i = iOrig, j = jOrig;
            while (i < j) {
                int t = num[i] + num[j] + num[k];

                if (iOrig != i && num[i] == num[i - 1]) {
                    i++;
                } else if (jOrig != j && num[j] == num[j + 1]) {
                    j--;
                } else if (t < 0) {
                    i++;
                } else if (t > 0) {
                    j--;
                } else {
                    ArrayList<Integer> tr = new ArrayList<Integer>();
                    tr.add(num[k]);
                    tr.add(num[i++]);
                    tr.add(num[j--]);
                    result.add(tr);
                }
            }

            while (k < n - 1 && num[k + 1] == num[k]) {
                k++;
            }
        }

        return result;
    }
}

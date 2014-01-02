
import java.util.ArrayList;
import java.util.Collections;

public class three_sum {
    static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sortedNums = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            sortedNums.add(num[i]);
        }
        Collections.sort(sortedNums);

        int N = num.length;
        for (int i = 0; i < N - 2 && sortedNums.get(i) <= 0; i++) {
            if (i > 0 && sortedNums.get(i) == sortedNums.get(i - 1)) {
                continue;
            }

            int expectedTwoSum = 0 - sortedNums.get(i);
            int l = i + 1;
            int r = N - 1;
            while (l < r) {
                int sum = sortedNums.get(l) + sortedNums.get(r);
                if (sum < expectedTwoSum) {
                    ++l;
                } else if (sum > expectedTwoSum) {
                    --r;
                } else {
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(sortedNums.get(i));
                    triple.add(sortedNums.get(l));
                    triple.add(sortedNums.get(r));
                    result.add(triple);
                    
                    l++;
                    r--;
                    while (l < r && sortedNums.get(l) == sortedNums.get(l - 1)) {
                        l++;
                    }
                    while (l < r && sortedNums.get(r) == sortedNums.get(r - 1)) {
                        r--;
                    }
                }
            }
            
        }
        
        return result;
    }

    public static void main(String[] args) {
        threeSum(new int[] {-1, 0, 1, 2, -1, -4});
    }
}

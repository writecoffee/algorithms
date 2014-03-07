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
        int[] stack = new int[k];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int stackPointer = 0;

        while (true) {
            if (stack[stackPointer] >= n) {
                if (stackPointer == 0) {
                    break;
                }

                stackPointer--;
                stack[stackPointer]++;
            } else if (stackPointer == k - 1) {
                ArrayList<Integer> newResult = new ArrayList<Integer>();
                for (int j = 0; j < k; j++) {
                    newResult.add(stack[j] + 1);
                }
                result.add(newResult);

                stack[stackPointer]++;
            } else {
                stackPointer++;
                stack[stackPointer] = stack[stackPointer - 1] + 1;
            }
        }

        for (int i = 0; i < stack.length; i++) {
            assert stack[i] == n;
        }
        
        return result;
    }

    public static void main(String[] args) {
        combineNonrecur(4, 3);
    }
}
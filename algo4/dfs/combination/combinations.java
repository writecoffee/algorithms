package combination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        explore(new ArrayList<Integer>(), 0, n, k, result);
        return result;
    }

    void explore(ArrayList<Integer> nxt, int i, int n, int k, ArrayList<ArrayList<Integer>> result) {
        if (nxt.size() == k) {
            result.add(new ArrayList<Integer>(nxt));
            return;
        }

        for (int j = i; j < n; ++j) {
            nxt.add(j + 1);
            explore(nxt, j + 1, n, k, result);
            nxt.remove(nxt.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combineNonrecur(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Deque<Integer> s = new ArrayDeque<Integer>();
        s.addLast(1);

        while (true) {
            if (s.peekLast() > n) {
                if (s.size() == 1) {
                    break;
                }

                s.removeLast();
                s.addLast(s.removeLast() + 1);
            } else if (s.size() == k) {
                result.add(new ArrayList<Integer>(s));
                s.addLast(s.removeLast() + 1);
            } else {
                s.addLast(s.peekLast() + 1);
            }
        }

        return result;
    }
}
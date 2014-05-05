package pruning;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;

public class all_word_break_partitioning {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        explore(s, s.length() - 1, dict, new ArrayDeque<String>(), preprocess(s, dict), result);
        return result;
    }

    private void explore(String s, int end, Set<String> dict, ArrayDeque<String> path, boolean[] isBreak, ArrayList<String> result) {
        if (end == -1) {
            result.add(convert(path));
            return;
        } else if (!isBreak[end]) {
            return;
        }

        for (int i = end; i >= 0; --i) {
            String t = s.substring(i, end + 1);

            if (dict.contains(t)) {
                path.addFirst(t);
                explore(s, i - 1, dict, path, isBreak, result);
                path.pollFirst();
            }
        }
    }

    private boolean[] preprocess(String s, Set<String> dict) {
        int n = s.length();
        boolean[] isBreak = new boolean[n];

        for (int i = 0; i < n; ++i) {
            for (int j = i; j >= 0; --j) {
                if (dict.contains(s.substring(j, i + 1)) && (j == 0 || isBreak[j - 1])) {
                    isBreak[i] = true;
                    break;
                }
            }
        }

        return isBreak;
    }

    private String convert(ArrayDeque<String> path) {
        StringBuilder sb = new StringBuilder();

        for (String s : path) {
            sb.append(s);
            sb.append(' ');
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
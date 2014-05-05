package string;

import java.util.ArrayList;
import java.util.Set;

public class dp_word_break_all_partitioning {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<ArrayList<String>>> dp = new ArrayList<ArrayList<ArrayList<String>>>();
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            ArrayList<ArrayList<String>> cr = new ArrayList<ArrayList<String>>();
            dp.add(cr);

            for (int j = i; j >= 0; --j) {
                String t = s.substring(j, i + 1);

                if (dict.contains(t) && j == 0) {
                    ArrayList<String> nxt = new ArrayList<String>();
                    nxt.add(t);
                    cr.add(nxt);
                } else if (dict.contains(t)) {
                    ArrayList<ArrayList<String>> pre = dp.get(j - 1);

                    for (ArrayList<String> p : pre) {
                        ArrayList<String> nxt = new ArrayList<String>(p);
                        nxt.add(t);
                        cr.add(nxt);
                    }
                }
            }
        }

        return convert(dp.get(n - 1));
    }

    private ArrayList<String> convert(ArrayList<ArrayList<String>> allPaths) {
        ArrayList<String> result = new ArrayList<String>();

        for (ArrayList<String> path : allPaths) {
            StringBuilder sb = new StringBuilder();

            for (String word : path) {
                sb.append(word);
                sb.append(' ');
            }

            result.add(sb.deleteCharAt(sb.length() - 1).toString());
        }

        return result;
    }
}
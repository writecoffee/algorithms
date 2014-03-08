import java.util.ArrayList;
import java.util.HashMap;

public class substring_with_concatenation_of_all_words {
    public static ArrayList<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int m = S.length();
        int n = L.length;
        int k = L[0].length();

        HashMap<String, Integer> need = new HashMap<String, Integer>();
        HashMap<String, Integer> found = new HashMap<String, Integer>();
        for (int i = 0; i < n; i++) {
            if (need.containsKey(L[i])) {
                need.put(L[i], need.get(L[i]) + 1);
            } else {
                need.put(L[i], 1);
            }
        }

        for (int i = 0; i <= m - n * k; i++) {
            for (int j = 0; j < n; j++) {
                found.put(L[j], 0);
            }

            int j;
            for (j = 0; j < n; ++j) {
                String s = S.substring(i + j * k, i + (j + 1) * k);

                if (!need.containsKey(s) || need.get(s) <= found.get(s)) {
                    break;
                }

                found.put(s, found.get(s) + 1);
            }

            if (j == n) {
                result.add(i);
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        findSubstring("barfoothefoobarman", new String[] { "foo", "bar" });
    }
}
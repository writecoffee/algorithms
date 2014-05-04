import java.util.ArrayList;

public class all_palindrome_partitioning {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        explore(s, 0, new ArrayList<String>(), result);
        return result;
    }

    public void explore(String s, int start, ArrayList<String> path, ArrayList<ArrayList<String>> result) {
        int n = s.length();

        if (start == n) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = start + 1; i <= n; ++i) {
            String t = s.substring(start, i);

            if (isPalindrome(t)) {
                path.add(t);
                explore(s, i, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
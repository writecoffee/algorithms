import java.util.ArrayList;

public class palindrome_partitioning {
    public static ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        explore(s, 0, new ArrayList<String>(), result);
        return result;
    }

    public static void explore(String s, int start, ArrayList<String> path, ArrayList<ArrayList<String>> result) {
        int n = s.length();

        if (start == n) {
            result.add(new ArrayList<String>(path));
            return;
        }

        for (int i = start + 1; i <= n; ++i) {
            path.add(s.substring(start, i));
            if (isPalindrome(s, start, i)) {
                explore(s, i, path, result);
            }
            path.remove(path.size() - 1);
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        int i = start;
        int j = end - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    
    public static void main(String[] args) {
        partition("aa");
    }
}
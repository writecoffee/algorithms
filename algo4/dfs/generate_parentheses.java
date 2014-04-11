import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class generate_parentheses {
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }

        String str = "";
        getParenthesis(n, n, str, result);
        return result;
    }

    public static void getParenthesis(int leftCounter, int rightCounter, String str, ArrayList<String> result) {
        if (leftCounter == 0 && rightCounter == 0) {
            result.add(str);
            return;
        }

        if (leftCounter == 0) {
            getParenthesis(0, rightCounter - 1, str + ")", result);
        } else if (leftCounter > 0) {
            getParenthesis(leftCounter - 1, rightCounter, str + "(", result);
            if (rightCounter > leftCounter) {
                getParenthesis(leftCounter, rightCounter - 1, str + ")", result);
            }
        }
    }

    public static ArrayList<String> generateParenthesisNonrecur(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }

        Stack<String> s = new Stack<String>();
        HashMap<String, Integer> hl = new HashMap<String, Integer>();
        HashMap<String, Integer> hr = new HashMap<String, Integer>();
        s.push("(");
        hl.put("(", n - 1);
        hr.put("(", n);

        while (!s.isEmpty()) {
            String c = s.pop();
            int lc = hl.get(c);
            int rc = hr.get(c);

            if (lc == 0 && rc == 0) {
                result.add(c);
                continue;
            }

            if (lc == 0) {
                s.push(c + ")");
                hl.put(c + ")", lc);
                hr.put(c + ")", rc - 1);
            } else {
                if (rc > lc) {
                    s.push(c + ")");
                    hl.put(c + ")", lc);
                    hr.put(c + ")", rc - 1);
                }

                s.push(c + "(");
                hl.put(c + "(", lc - 1);
                hr.put(c + "(", rc);
            }
        }

        return result;
    }
}
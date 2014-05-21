import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class generate_parentheses {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (n == 0) {
            return result;
        }

        explore(n, n, new StringBuilder(), result);
        return result;
    }

    private void explore(int leftCounter, int rightCounter, StringBuilder s, ArrayList<String> result) {
        if (leftCounter == 0 && rightCounter == 0) {
            result.add(s.toString());
            return;
        }

        if (leftCounter > 0) {
            explore(leftCounter - 1, rightCounter, s.append("("), result);
            s.deleteCharAt(s.length() - 1);
        }

        if (rightCounter > leftCounter) {
            explore(leftCounter, rightCounter - 1, s.append(")"), result);
            s.deleteCharAt(s.length() - 1);
        }
    }

    public ArrayList<String> generateParenthesisNonrecur(int n) {
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
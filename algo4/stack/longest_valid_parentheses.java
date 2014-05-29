import java.util.Stack;

public class longest_valid_parentheses {
    public int longestValidParentheses(String s) {
        int result = 0, n = s.length();
        Stack<Integer> stk = new Stack<Integer>();
        int l = 0;

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);

            if (c == '(') {
                stk.push(i);
            } else if (c == ')' && stk.isEmpty()) {
                l = i + 1;
            } else {
                stk.pop();

                if (stk.isEmpty()) {
                    result = Math.max(result, i - l + 1);
                } else {
                    result = Math.max(result, i - stk.peek());
                }
            }
        }

        return result;
    }
}

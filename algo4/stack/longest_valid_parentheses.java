import java.util.Stack;

public class longest_valid_parentheses {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int last = -1;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - last);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        longestValidParentheses(")()())");
    }
}
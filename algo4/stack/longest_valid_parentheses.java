import java.util.Stack;

public class longest_valid_parentheses {
    public static int longestValidParentheses(String s) {
        int maxLen = 0;
        int currStart = -1;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                continue;
            }

            if (!stack.isEmpty()) {
                stack.pop();

                if (stack.isEmpty()) {
                    maxLen = Math.max(maxLen, i - currStart);
                } else {
                    /**
                     * Preclude any preceding redundant '('
                     */
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            } else {
                currStart = i;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()()"));
    }
}
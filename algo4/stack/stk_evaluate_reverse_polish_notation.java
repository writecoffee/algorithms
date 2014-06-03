import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 * 
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * {@linkplain https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/}
 *
 */
public class stk_evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<Integer>();
        int n = tokens.length;

        for (int i = 0; i < n; ++i) {
            char c = tokens[i].charAt(0);

            if (Character.isDigit(c) || ((c == '+' || c == '-') && tokens[i].length() > 1)) {
                stk.push(Integer.parseInt(tokens[i]));
            } else {
                int r = stk.pop(), l = stk.pop();

                switch (c) {
                case '+':
                    stk.push(l + r);
                    break;
                case '-':
                    stk.push(l - r);
                    break;
                case '*':
                    stk.push(l * r);
                    break;
                case '/':
                    stk.push(l / r);
                    break;
                default:
                    break;
                }
            }
        }

        return stk.pop();
    }
}
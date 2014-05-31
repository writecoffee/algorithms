package recursion;
import java.util.Stack;

/**
 * Validate an expression.
 * 
 * The expression only includes:
 * 
 * digit: '0' - '9'
 * binary operator: '+', '-'
 * parenthesis: '(', ')'
 * 
 * For example:
 * 
 * "1"                 true
 * "10+(2-(31+(4)))"   true
 * "-1"                false
 * "1+"                false
 * 
 * {@linkplain http://www.itint5.com/oj/41/#41}
 *
 */
public class stk_validate_expression {
    private enum Token {
        EMPTY, NUMBER, OPERATOR, L_PAREN, R_PAREN
    }

    public boolean validate(String expr) {
        int n = expr.length();
        Stack<Token> s = new Stack<Token>();
        s.push(Token.EMPTY);

        for (int i = 0; i < n; ++i) {
            if (expr.charAt(i) == '+' || expr.charAt(i) == '-') {
                if (s.peek() != Token.NUMBER) {
                    return false;
                } else {
                    s.push(Token.OPERATOR);
                }
            } else if (expr.charAt(i) == '(') {
                if (s.peek() == Token.NUMBER) {
                    return false;
                } else {
                    s.push(Token.L_PAREN);
                }
            } else if (expr.charAt(i) == ')') {
                if (s.pop() != Token.NUMBER) {
                    return false;
                } else if (s.pop() != Token.L_PAREN) {
                    return false;
                } else if (s.peek() == Token.OPERATOR) {
                    s.pop();
                } else {
                    s.push(Token.NUMBER);
                }
            } else {
                i = pollNumber(expr, i);

                if (i == -1) {
                    return false;
                } else {
                    i--;
                }

                if (s.peek() == Token.OPERATOR) {
                    s.pop();
                } else {
                    s.push(Token.NUMBER);
                }
            }
        }

        return s.size() == 2 && s.peek() == Token.NUMBER;
    }

    private int pollNumber(String expr, int i) {
        int j = i;
        int n = expr.length();
        boolean isZerp = expr.charAt(i) == '0';

        while (j < n && expr.charAt(j) >= '0' && expr.charAt(j) <= '9') {
            j++;
        }

        if (j == i || isZerp && j - i > 1) {
            return -1;
        }

        return j;
    }
}
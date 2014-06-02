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
public class stk_validate_parenthesizable_expression {
    private enum Token {
        EMPTY, NUMBER, OPERATOR, L_PAREN, R_PAREN
    }

    /**
     * To express the grammer in BNF form, we have
     * 
     * expr := num | ( expr ) | expr bop expr
     * bop := + | -
     * num := [1-9]*[0-9]
     * 
     * Intuitively, we can parse the input in a recursive manner, while we keep
     * track of the previous "token" parsed.
     * 
     * The key observation here is that the final output should be a value. For the
     * last token we parsed, we can convert the result by popping out all previous
     * token stored in the stack.
     * 
     * So we can use a stack to keep track of this, and the expected result should be
     * resulted from a stack with just a number token only. We can also push a dummy
     * value into the stack in case of underflow.
     * 
     */
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
                int len = pollNumber(expr, i);

                if (len == -1) {
                    return false;
                }

                i += len - 1;

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
        int n = expr.length();
        boolean isZero = expr.charAt(i) == '0';

        int j = i;
        while (j < n && Character.isDigit(expr.charAt(i))) {
            j++;
        }

        if (isZero && j - i > 1) {
            return -1;
        }

        return j - i;
    }
}
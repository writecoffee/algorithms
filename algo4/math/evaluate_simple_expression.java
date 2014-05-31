/**
 * Given an expression, including only non-negative number, '+', '-', '*' operators.
 * The task is to evaluate the expression.
 * 
 * The assumption is that all input expression is legal.
 * 
 * {@linkplain http://www.itint5.com/oj/#26}
 *
 */
public class evaluate_simple_expression {
    public int evaluateNonrecur(String expr) {
        int result = 0;
        int n = expr.length();
        int k = 1;

        for (int i = 0; i < n; ++i) {
            int operand = 0;
            while (i < n && expr.charAt(i) >= '0' && expr.charAt(i) <= '9') {
                operand = operand * 10 + (expr.charAt(i++) - '0');
            }
            k *= operand;

            if (i < n && expr.charAt(i) == '*') {
                continue;
            } else {
                result += k;
                k = i == n ? k : (expr.charAt(i) == '+' ? 1 : -1);
            }
        }

        return result;
    }

    /**
     * In order to preserve the higher precedence of '*' operator, we should figure out
     * a way of representing '+' and '-'. So we can evaluate '+' and '-' in right
     * associative manner.
     * 
     * So if there is an expression, "1 + 3 * 2", it can be converted into a form with
     * coefficients "1 * 1 + 3 * 2". For minus, it should be similar. "1 - 3 + 2" could
     * be turned into a form "1 * 1 + (-1) * 3 + 1 * 2".
     * 
     * It is straightforward that the coefficient can be passed from the previous 
     * calculation and let the coefficient multiply the number we pull off from the string.
     * 
     */
    public int evaluate(String expr, int i, int k) {
        int n = expr.length();

        int operand = 0;
        while (i < n && expr.charAt(i) >= '0' && expr.charAt(i) <= '9') {
            operand = operand * 10 + (expr.charAt(i++) - '0');
        }

        if (i == n) {
            return k;
        } else if (expr.charAt(i) == '+') {
            return k * operand + evaluate(expr, i + 1, 1);
        } else if (expr.charAt(i) == '-') {
            return k * operand + evaluate(expr, i + 1, -1);
        } else {
            return evaluate(expr, i + 1, k * operand);
        }
    }

    public int evaluate(String expr) {
        return evaluate(expr, 0, 1);
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an expression string array, return the Reverse Polish notation of this
 * expression. (remove the parentheses)
 *
 * For the expression [3 - 4 + 5] (which denote by ["3", "-", "4", "+", "5"]),
 * return [3 4 - 5 +] (which denote by ["3", "4", "-", "5", "+"]).
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/convert-expression-to-reverse-polish-notation/}
 * [Difficulty] - Hard
 *
 */
public class stk_convert_expression_to_reverse_polish_notation
{
    public ArrayList<String> convertToRPN(String[] expression)
    {
        ArrayList<String> result = new ArrayList<>();

        int n = expression.length;
        List<Integer> precedences = new ArrayList<>();
        List<String> symbols = new ArrayList<>();
        int base = 1;

        for (int i = 0; i < n; i++) {
            String exp = expression[i];

            if ("-".equals(exp)) {
                precedences.add(1 + base);
                symbols.add(exp);
            } else if ("+".equals(exp)) {
                precedences.add(1 + base);
                symbols.add(exp);
            } else if ("*".equals(exp)) {
                precedences.add(2 + base);
                symbols.add(exp);
            } else if ("/".equals(exp)) {
                precedences.add(2 + base);
                symbols.add(exp);
            } else if ("(".equals(exp)) {
                base += 10;
            } else if (")".equals(exp)) {
                base -= 10;
            } else {
                precedences.add(Integer.MAX_VALUE);
                symbols.add(exp);
            }
        }
        symbols.add("-");
        precedences.add(Integer.MIN_VALUE);

        Stack<Integer> stkPrecedence = new Stack<>();
        Stack<String> stkSymbols = new Stack<>();

        for (int i = 0; i < precedences.size(); i++) {
            int precedenceVal = precedences.get(i);
            String symbol = symbols.get(i);

            while (!stkPrecedence.isEmpty()) {
                int precedenceLargest = stkPrecedence.peek();
                String symbolLargest = stkSymbols.peek();

                if (precedenceLargest < precedenceVal) {
                    break;
                }

                stkPrecedence.pop();
                stkSymbols.pop();
                result.add(symbolLargest);
            }

            stkPrecedence.push(precedenceVal);
            stkSymbols.push(symbol);
        }

        return result;
    }
}

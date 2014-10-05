import java.util.ArrayList;
import java.util.List;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 *
 * "3+2*2" = 7
 *
 * "3/2 " = 1 "
 *
 * 3+5 / 2 " = 5
 *
 * [Source]      - {@linkplain https://leetcode.com/problems/basic-calculator-ii/}
 * [Difficulty]  - Medium
 * [Tediousness] - Medium
 *
 */
public class stk_basic_calculator_II
{
    public int calculate(String s)
    {
        int n = s.length();
        char[] cs = s.toCharArray(), ops = "*/+-".toCharArray();
        List<Character> opStack = new ArrayList<>();
        List<Integer> valStack = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            char c = cs[i];

            if (c == ' ') {
                continue;
            } else if (contains(ops, c)) {
                opStack.add(c);

            } else {
                int val = c - '0';

                for (; i + 1 < n && Character.isDigit(s.charAt(i + 1)); ++i) {
                    val = 10 * val + (s.charAt(i + 1) - '0');
                }

                valStack.add(val);
                operate(opStack, valStack);
            }
        }

        int result = valStack.get(0);
        for (int i = 1; i < valStack.size(); ++i) {
            int sign = opStack.get(i - 1) == '-' ? -1 : 1;
            result = result + sign * valStack.get(i);
        }

        return result;
    }

    private void operate(List<Character> opStack, List<Integer> valStack)
    {
        char op = opStack.get(opStack.size() - 1);

        if (op == '*' || op == '/') {
            int rOp = valStack.remove(valStack.size() - 1),
                lOp = valStack.remove(valStack.size() - 1);

            opStack.remove(opStack.size() - 1);

            if (op == '*') {
                valStack.add(lOp * rOp);
            } else {
                valStack.add(lOp / rOp);
            }
        }
    }

    private boolean contains(char[] ops, char c)
    {
        for (char op : ops) {
            if (op == c) {
                return true;
            }
        }

        return false;
    }
}

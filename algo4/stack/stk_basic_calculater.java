import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 *
 * "1 + 1" = 2
 *
 * " 2-1 + 2 " = 3
 *
 * "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/basic-calculator/}
 *
 */
public class stk_basic_calculater
{
    public int calculate(String s)
    {
        Stack<Integer> signStack = new Stack<>();
        int rs = 0, n = s.length();
        int sign = 1;
        signStack.push(sign);

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);

            if (c == ' ') {
                continue;
            } else if (c == '(') {
                signStack.push(signStack.peek() * sign);
                sign = 1;
            } else if (c == ')') {
                signStack.pop();
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)) {
                int t = c - '0';

                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    i++;
                    t = t * 10 + (s.charAt(i) - '0');
                }

                rs = rs + sign * signStack.peek() * t;
            }
        }

        return rs;
    }
}

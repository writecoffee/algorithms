import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://oj.leetcode.com/problems/valid-parentheses/}
 * 
 */
public class stk_validate_parentheses_sequence {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<Character>();

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else if (stk.isEmpty() || Math.abs(stk.pop() - c) > 2) {
                return false;
            }
        }

        return stk.isEmpty();
    }
}
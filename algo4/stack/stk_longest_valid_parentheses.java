import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * 
 *
 */
public class stk_longest_valid_parentheses
{
    /**
     * We can use a stack to keep track of open left parenthesis and use a left window
     * to record the starting position of the current window.
     * 
     * So if the there is mismatch ')', clear the window. Update gMax when we found a
     * match.
     * 
     */
    public int longestValidParentheses(String s)
    {
        Stack<Integer> stk = new Stack<>();
        int n = s.length();
        int l = 0, gMax = 0;

        for (int r = 0; r < n; ++r) {
            if (s.charAt(r) == '(') {
                stk.push(r);
            } else if (s.charAt(r) == ')' && stk.isEmpty()) {
                l = r + 1;
            } else if (s.charAt(r) == ')') {
                stk.pop();

                if (stk.isEmpty()) {
                    gMax = Math.max(gMax, r - l + 1);
                } else {
                    gMax = Math.max(gMax, r - stk.peek());
                }
            }
        }

        return gMax;
    }

    /**
     * A wrong and greedy way to get rid of stack is to use an integer to keep track of open '('s,
     * deducing the counter when hitting a close ')' and reset when hitting invalid ')'.
     * 
     * It looks good. But it cannot differentiate "(()()" and "()(()" since there is no way to keep
     * track of positions of invalid '('!
     * 
     * Similarly, if we iterate the string from right to left and let ')' as an open parenthesis, it
     * cannot differentiate "()())" and "())()".
     * 
     * What if we iterate the string twice, one going forwards and the other going backwards, and
     * then pick up the smaller one? It seems to be able to fix the problem.
     * 
     * Unfortunately, it will return 4 for "())()(()".
     * 
     * So we need to adjust the algorithm a little bit, and being a little be conservative -- update
     * maximum length only when the current counter is exhausted.
     * 
     *     (1) Forward: match from left to right, skip mismatch ')' and clear counter.
     *     (2) Backward: match from right to left, skip mismatch '(' and clear counter.
     *     (3) We conclude and update gMax only when the current counter is deduced down to 0. For
     *         example, if there is redundant '(' in "()(()()" if we are looking forward, then it 
     *         will be detected when we are looking backward trying the opposite way.
     * 
     */
    private int match(String s, int start, int end, int stride, char forward)
    {
        int gMax = 0, count = 0, lMax = 0;

        for (int i = start; i != end; i += stride) {
            if (s.charAt(i) == forward) {
                ++count;
            } else if (count-- > 0) {
                lMax += 2;
                gMax = count == 0 ? Math.max(gMax, lMax) : gMax;
            } else {
                lMax = count = 0;
            }
        }

        return gMax;
    }

    public int longestValidParenthesesWithoutStack(String s)
    {
        return Math.max(match(s, 0, s.length(), 1, '('), match(s, s.length() - 1, -1, -1, ')'));
    }
}

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * [Difficulty] - Easy
 * [Source]     - Amazon interview, {@linkplain https://leetcode.com/problems/min-stack/}
 * [Tag]        - $stack$, $state machine$
 *
 */
public class stk_stack_with_min_function
{
    public static class MinStack
    {
        private Stack<Integer> currentMins = new Stack<Integer>(),
                               stk = new Stack<Integer>();

        public void push(int x)
        {
            if (currentMins.isEmpty()) {
                currentMins.push(x);
            } else if (x <= currentMins.peek()) {
                currentMins.push(x);
            }

            stk.push(x);
        }

        public void pop()
        {
            int result = stk.pop();

            if (result == currentMins.peek()) {
                currentMins.pop();
            }
        }

        public int top()
        {
            return stk.peek();
        }

        public int getMin()
        {
            return currentMins.peek();
        }
    }
}

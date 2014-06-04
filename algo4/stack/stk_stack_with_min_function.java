import java.util.NoSuchElementException;
import java.util.Stack;

public class stk_stack_with_min_function {
    public static class MinStack {
        private final Stack<Integer> s;
        private final Stack<Integer> minStack;

        public int min() {
            if (s.isEmpty()) {
                throw new NoSuchElementException("Stack underflow");
            }

            return minStack.peek();
        }

        public MinStack() {
            s = new Stack<Integer>();
            minStack = new Stack<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public int pop() {
            if (s.isEmpty()) {
                throw new NoSuchElementException("Stack underflow");
            }

            int result = s.pop();
            if (result == minStack.peek()) {
                minStack.pop();
            }

            return result;
        }

        public boolean isEmpty() {
            return s.isEmpty();
        }

        public void push(int v) {
            if (v < minStack.peek()) {
                minStack.push(v);
            }

            s.push(v);
        }

        public int peek() {
            if (s.isEmpty()) {
                throw new NoSuchElementException("Stack underflow");
            }

            return s.peek();
        }
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(4);
        s.push(3);

        try {
            assert s.min() == 3;
            assert s.pop() == 3;
            assert s.min() == 4;
            assert s.pop() == 4;
            s.min();
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }
}

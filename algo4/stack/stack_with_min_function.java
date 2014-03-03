import java.util.Stack;

public class stack_with_min_function {

    public static class UnderflowException extends Exception {
        private static final long serialVersionUID = 4805333897944620573L;
        UnderflowException(String message) {
            super(message);
        }
    }

    public static class MinStack {
        public final Stack<Integer> s;
        private final Stack<Integer> minStack;

        public int min() throws UnderflowException {
            if (s.isEmpty()) {
                throw new UnderflowException("Stack underflow");
            }

            return minStack.peek();
        }

        MinStack() {
            s = new Stack<Integer>();
            minStack = new Stack<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public int pop() throws UnderflowException {
            if (s.isEmpty()) {
                throw new UnderflowException("Stack underflow");
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

        public int peek() throws UnderflowException {
            if (s.isEmpty()) {
                throw new UnderflowException("Stack underflow");
            }

            return s.peek();
        }
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(4);
        s.push(3);

        try {
            assert s.pop() == 3;
            assert s.min() == 4;
            assert s.pop() == 4;
            s.min();
        } catch (UnderflowException e) {
            System.out.println(e.getMessage());
        }
    }
}
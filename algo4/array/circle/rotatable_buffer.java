package circle;

public class rotatable_buffer {
    private Object[] buffer;
    private int head = 0;

    /**
     * The class supports an array-like data structure where the head
     * can be efficiently rotated.
     * 
     */
    public rotatable_buffer(int capacity) {
        buffer = new Object[capacity];
    }

    private int convert(int offset) {
        while (offset < 0) {
            offset += buffer.length;
        }

        return (head + offset) % buffer.length;
    }

    public void rotate(int offset) {
        head = convert(offset);
    }

    public Object get(int i) {
        if (i < 0 || i >= buffer.length) {
            throw new IndexOutOfBoundsException();
        }

        return buffer[convert(i)];
    }

    public void set(int i, Object item) {
        buffer[convert(i)] = item;
    }
}
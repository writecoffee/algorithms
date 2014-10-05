public class bd_circular_buffer
{
    private Object[] buffer;
    private int      head;
    private int      size;

    public bd_circular_buffer(int capacity)
    {
        buffer = new Object[capacity];
    }

    public synchronized void addLast(Object v) throws InterruptedException
    {
        while (size == buffer.length) {
            wait();
        }

        int tail = (head + size) % buffer.length;
        buffer[tail] = v;

        if (size++ == 0) {
            notifyAll();
        }
    }

    public synchronized Object pollFirst() throws InterruptedException
    {
        while (size == 0) {
            wait();
        }

        Object result = buffer[head];
        head = (head + 1) % buffer.length;

        if (size-- == buffer.length) {
            notifyAll();
        }

        return result;
    }

    public synchronized Object get(int index)
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        return (head + index) % buffer.length;
    }
}

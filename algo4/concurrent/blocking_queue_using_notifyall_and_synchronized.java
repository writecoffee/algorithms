import java.util.LinkedList;
import java.util.Queue;

public class blocking_queue_using_notifyall_and_synchronized
{
    public final int capacity;
    private Queue<Object> q;

    public blocking_queue_using_notifyall_and_synchronized(int _capacity) {
        capacity = _capacity;
        q = new LinkedList<Object>();
    }

    public synchronized void addLast(Object o) throws InterruptedException
    {
        if (q.size() == 0) {
            q.add(o);
            notifyAll();
        } else if (q.size() < capacity) {
            q.add(o);
        } else {
            while (q.size() == capacity) {
                wait();
            }
            q.add(o);
        }
    }

    public synchronized Object pollFirst() throws InterruptedException
    {
        Object result;

        if (q.size() == capacity) {
            result = q.poll();
            notifyAll();
        } else if (q.size() > 0) {
            result = q.poll();
        } else {

            while (q.size() == 0) {
                wait();
            }

            result = q.poll();
        }

        return result;
    }
}

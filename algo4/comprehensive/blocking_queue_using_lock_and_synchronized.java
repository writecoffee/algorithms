import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class blocking_queue_using_lock_and_synchronized {
    public final int capacity;
    private int count;
    private Lock lock;
    private Condition notEmpty;
    private Condition notFull;
    private Queue<Object> q;

    public blocking_queue_using_lock_and_synchronized(int _capacity) {
        capacity = _capacity;
        count = 0;
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
        q = new LinkedList<Object>();
    }

    public synchronized void addLast(Object o) throws InterruptedException {
        if (count < 0) {
            count++;
            q.add(o);
            notEmpty.notify();
        } else if (count < capacity) {
            count++;
            q.add(o);
        } else {
            if (count == capacity) {
                notFull.wait();
            }
            q.add(o);
            count++;
        }
    }

    public synchronized Object pollFirst() throws InterruptedException {
        Object result;

        if (count == capacity) {
            count--;
            result = q.poll();
            notFull.notify();
        } else if (count > 0) {
            count--;
            result = q.poll();
        } else {
            count--;
            if (count < 0) {
                notEmpty.wait();
            }
            result = q.poll();
        }

        return result;
    }
}

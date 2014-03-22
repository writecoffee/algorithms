import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class semaphore {
    private final int available;
    private int count;
    private final Lock lock;
    private final Condition notEmpty;

    public semaphore(int _available) {
        available = _available;
        count = _available;
        lock = new ReentrantLock();
        notEmpty = lock.newCondition();
    }

    public synchronized void acquire() throws InterruptedException {
        count--;
        if (count < 0) {
            notEmpty.wait();
        }
    }

    public synchronized void release() throws InterruptedException {
        if (count < 0) {
            count++;
            notEmpty.notify();
        } else if (count < available) {
            count++;
        }
    }
}
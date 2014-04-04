import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class blocking_queue_using_lock_and_atomic_integer<E> {
    private final Queue<E> q = new LinkedList<E>();
    private final int capacity;
    private final AtomicInteger count = new AtomicInteger(0);

    private final ReentrantLock lockNotFull = new ReentrantLock();
    private final ReentrantLock lockNotEmpty = new ReentrantLock();

    private final Condition notFull = lockNotFull.newCondition();
    private final Condition notEmpty = lockNotEmpty.newCondition();

    public blocking_queue_using_lock_and_atomic_integer(int _capacity) {
        capacity = _capacity;
    }

    public void add(E e) throws InterruptedException {
        int oldCount;
        lockNotFull.lock();
        try {
            while (count.get() == capacity) {
                notFull.wait();
            }

            q.add(e);
            oldCount = count.getAndIncrement();

            /*
             *  Notify other producers for count change if multiple producers
             *  encountered a full queue since condition.signal() can only
             *  wake up one thread at a time.
             */
            if (oldCount + 1 < capacity) {
                notFull.signal();
            }
        } finally {
            lockNotFull.unlock();
        }

        /*
         *  Notify other waiting consumers.
         */
        if (oldCount == 0) {
            lockNotEmpty.lock();
            try {
                notEmpty.signal();
            } finally {
                lockNotEmpty.unlock();
            }
        }
    }

    public E remove() throws InterruptedException {
        E e;

        int oldCount;
        lockNotEmpty.lock();
        try {
            while (count.get() == 0) {
                notEmpty.await();
            }

            e = q.remove();
            oldCount = count.getAndDecrement();

            /*
             *  Notify other consumers for count change if multiple consumers
             *  encountered an empty queue since condition.signal() can only
             *  wake up one thread at a time.
             */
            if (oldCount > 1) {
                notEmpty.signal();
            }
        } finally {
            lockNotEmpty.unlock();
        }

        /*
         *  Notify other waiting producers.
         */
        if (oldCount == capacity) {
            lockNotFull.lock();
            try {
                notFull.signal();
            } finally {
                lockNotFull.unlock();
            }
        }

        return e;
    }

    public E peek() {
        if (count.get() == 0) {
            return null;
        }

        lockNotEmpty.lock();
        try {
            return q.peek();
        } finally {
            lockNotEmpty.unlock();
        }
    }
}
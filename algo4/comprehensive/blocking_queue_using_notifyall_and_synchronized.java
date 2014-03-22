import java.util.LinkedList;
import java.util.Queue;

public class blocking_queue_using_notifyall_and_synchronized {
    private Queue<Object> q = new LinkedList<Object>();
    private int capacity = 10;

    public blocking_queue_using_notifyall_and_synchronized(int _capacity) {
        capacity = _capacity;
    }

    public synchronized void enqueue(Object item) throws InterruptedException {
        if (this.q.size() == capacity) {
            wait();
        }

        if (this.q.size() == 0) {
            notifyAll();
        }

        this.q.add(item);
    }

    public synchronized Object dequeue() throws InterruptedException {
        if (this.q.size() == 0) {
            wait();
        }

        if (this.q.size() == this.capacity) {
            notifyAll();
        }

        return this.q.remove(0);
    }
}
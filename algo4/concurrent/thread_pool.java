import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class thread_pool {
    private BlockingQueue<Runnable> taskQueue;

    private class PoolThread extends Thread {
        /**
         * {@code InterruptedException} would be thrown from the poll
         * method when the current thread is waiting on the blocking
         * queue's monitor.
         */
        @Override
        public void run() {
            while (!isKilled()) {
                Runnable runnable = (Runnable) taskQueue.poll();
                runnable.run();
            }
        }

        private synchronized void kill() {
            isStopped = true;
            interrupt();
        }

        private synchronized boolean isKilled() {
            return isStopped;
        }
    }

    private List<PoolThread> threads;
    private boolean isStopped = false;

    public thread_pool(int noOfThread) {
        taskQueue = new LinkedBlockingQueue<Runnable>();
        threads = new ArrayList<PoolThread>();

        for (int i = 0; i < noOfThread; i++) {
            threads.add(new PoolThread());
        }

        for (PoolThread t : threads) {
            t.start();
        }
    }

    public synchronized void execute(Runnable task) {
        if (isStopped) {
            throw new IllegalStateException("Thread pool is stopped");
        }

        taskQueue.add(task);
    }

    public synchronized void stop() {
        isStopped = true;
        for (PoolThread t : threads) {
            t.kill();
        }
    }
}
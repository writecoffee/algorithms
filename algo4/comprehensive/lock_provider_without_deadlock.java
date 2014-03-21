import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lock_provider_without_deadlock {
    public static class IllegalLockAccessException extends Exception {
        public IllegalLockAccessException(String string) {
            super(string);
        }

        private static final long serialVersionUID = -8612634472177391304L;
    }

    public static class LockManager {
        private static LockManager INSTANCE;

        /**
         * All the lock resources managed by {@code LockManager}.
         */
        private HashMap<Integer, LockNode> tableLocks;

        /**
         * Maps from a thread/owner/principal to the order that the owner claimed it would acquire the locks.
         */
        private HashMap<Integer, LinkedList<LockNode>> tablePrincipalLockAcquisition;

        private LockManager(HashMap<Integer, LockNode> _tableLocks) {
            tableLocks = _tableLocks;
        }

        public static LockManager getInstance() {
            return INSTANCE;
        }

        public static synchronized LockManager instialize(HashMap<Integer, LockNode> _tableLocks) {
            if (INSTANCE == null) {
                synchronized (LockManager.class) {
                    INSTANCE = new LockManager(_tableLocks);
                }
            }

            return INSTANCE;
        }

        private boolean hasCycle(LockNode v) {
            Set<LockNode> visited = new HashSet<LockNode>();
            Queue<LockNode> q = new LinkedList<LockNode>();
            q.add(v);
            visited.add(v);

            while (!q.isEmpty()) {
                LockNode current = q.poll();

                for (Entry<LockNode.EdgeKey, LockNode> edgeEntry : current.children.entrySet()) {
                    LockNode next = edgeEntry.getValue();

                    if (visited.contains(next)) {
                        return true;
                    }

                    visited.add(next);
                    q.add(next);
                }
            }

            return false;
        }

        /**
         * To prevent deadlocks, force the processes to declare up-front what order they will need
         * the locks in. Verify that this order does not create a deadlock (a cycle in a directed
         * graph).
         * </p>
         * If any cycles have been created, it will backtrack, removing these edges from 
         * the graph, and then exit.
         * </p>
         * For simplicity, we mark the entire method as "synchronized" so there will be only one
         * thread modifying/reading the graph at a time.
         * </p>
         */
        public synchronized boolean declare(int ownerId, int[] newDeclaredLockOrder) {
            assert newDeclaredLockOrder.length > 1;

            /**
             * G + V: add the edges to the present graph.
             */
            for (int i = 1; i < newDeclaredLockOrder.length; i++) {
                LockNode prev = tableLocks.get(newDeclaredLockOrder[i - 1]);
                LockNode curr = tableLocks.get(newDeclaredLockOrder[i]);
                prev.declareAcquiringNext(ownerId, curr);
            }

            /**
             * G - V: if cycle is detected.
             */
            if (hasCycle(tableLocks.get(newDeclaredLockOrder[0]))) {
                for (int i = 0; i < newDeclaredLockOrder.length; i++) {
                    LockNode p = tableLocks.get(newDeclaredLockOrder[i - 1]);
                    LockNode c = tableLocks.get(newDeclaredLockOrder[i]);
                    p.revoke(ownerId, c);
                }

                return false;
            }

            LinkedList<LockNode> locksSequence = new LinkedList<LockNode>();
            for (int i = 0; i < newDeclaredLockOrder.length; i++) {
                LockNode resource = tableLocks.get(newDeclaredLockOrder[i]);
                locksSequence.add(resource);
            }
            tablePrincipalLockAcquisition.put(ownerId, locksSequence);

            return true;
        }

        public synchronized Lock getLock(int ownerId) throws IllegalLockAccessException {
            LinkedList<LockNode> lockSequence = tablePrincipalLockAcquisition.get(ownerId);

            if (lockSequence == null) {
                throw new IllegalLockAccessException("Locks haven't been declared by owner: " + ownerId);
            } else if (lockSequence.isEmpty()) {
                throw new IllegalLockAccessException("Locks have already been all required by the owner: " + ownerId);
            }

            return lockSequence.removeFirst().lock;
        }

        public synchronized void quit(int ownerId) throws IllegalLockAccessException {
            LinkedList<LockNode> lockSequence = tablePrincipalLockAcquisition.get(ownerId);
            assert lockSequence.size() > 1;

            if (lockSequence == null) {
                throw new IllegalLockAccessException("Locks haven't been declared by owner: " + ownerId);
            }

            Object[] array = lockSequence.toArray();
            for (int i = 0; i < array.length - 1; i++) {
                LockNode current = (LockNode) array[i];
                LockNode next = (LockNode) array[i + 1];
                current.revoke(ownerId, next);
            }
        }
    }

    public static class LockNode {
        public static class EdgeKey {
            public final int ownerId;
            public final int destNodeId;
            public EdgeKey(int _ownerId, int _lockId) {
                ownerId = _ownerId;
                destNodeId = _lockId;
            }
        }

        public final HashMap<EdgeKey, LockNode> children;
        public final int id;
        public final Lock lock;

        public LockNode(int _id) {
            id = _id;
            lock = new ReentrantLock();
            children = new HashMap<EdgeKey, LockNode>();
        }

        public void declareAcquiringNext(int ownerId, LockNode node) {
            children.put(new EdgeKey(ownerId, node.id), node);
        }

        public void revoke(int ownerId, LockNode node) {
            children.remove(new EdgeKey(ownerId, node.id));
        }
    }
}
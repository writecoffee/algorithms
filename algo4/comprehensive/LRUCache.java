import java.util.HashMap;

public class LRUCache {
    private int capacity = 0;
    private int maxCapacity = 10;
    private DListNode head = null;
    private DListNode tail = null;
    private HashMap<Integer, DListNode> map = new HashMap<Integer, DListNode>();

    public LRUCache(int capacity) {
        setMaxCapacity(capacity);
    }

    public int get(int key) {
        final DListNode cur;

        if (map.containsKey(key)) {
            cur = map.get(key);

            if (cur != head) {
                remove(cur);
                insertToHead(cur);
            }

            return cur.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        int result = get(key);

        if (result == -1) {
            DListNode newNode = new DListNode(key, value);

            if (capacity == maxCapacity) {
                removeTail();
                capacity--;
            }

            insertToHead(newNode);
            map.put(key, newNode);
            capacity++;
        } else {
            head.val = value;
        }
    }

    public void setMaxCapacity(final int limit) {
        if (limit < 1) {
            throw new IllegalArgumentException("Max capacity must be positive.");
        }

        maxCapacity = limit;
    }

    private void remove(final DListNode cur) {
        if (cur.pre != null) {
            cur.pre.next = cur.next;
        }

        if (cur.next != null) {
            cur.next.pre = cur.pre;
        }

        if (tail == cur) {
            tail = cur.pre;
        }
    }

    private DListNode removeTail() {
        map.remove(tail.key);
        DListNode last = tail;
        tail = tail.pre;
        
        if (tail == null) {
            head = null;
            return last;
        }

        tail.next = null;
        return last;
    }

    private void insertToHead(final DListNode cur) {
        cur.next = head;
        cur.pre = null;
        if (head != null) {
            head.pre = cur;
        }

        head = cur;
        if (tail == null) {
            tail = cur;
        }
    }

    private class DListNode {
        DListNode pre = null;
        DListNode next = null;
        int val;
        int key;

        DListNode(int k, int v) {
            val = v;
            key = k;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(1);
        cache.set(2, 1);
        cache.get(2);
        cache.set(3, 2);
        cache.get(2);
    }
}
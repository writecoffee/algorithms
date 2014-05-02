import java.util.HashMap;

public class lru_cache_double_linkedlist {
    private class Node {
        private int val;
        private final int key;
        private Node next;
        private Node prev;

        private Node(int _key, int _val) {
            val = _val;
            key = _key;
        }

        private void setValue(int newVal) {
            val = newVal;
        }
    }

    private HashMap<Integer, Node> h;
    private Node head, tail;
    private int capacity;

    public lru_cache_double_linkedlist(int _capacity) {
        capacity = _capacity;
        h = new HashMap<Integer, Node>(_capacity, 1.0f);
        head = new Node(-1, -1);
        tail = head;
    }

    public int get(int key) {
        if (!h.containsKey(key)) {
            return -1;
        } else {
            return moveToFront(key).val;
        }
    }

    public void set(int key, int value) {
        if (h.containsKey(key)) {
            moveToFront(key).setValue(value);
        } else {
            if (h.size() == capacity) {
                removeTail();
            }

            Node c = new Node(key, value);
            tail.next = c;
            c.prev = tail;
            tail = c;
            h.put(key, c);
            moveToFront(key);
        }
    }

    private void removeTail() {
        Node c = h.remove(tail.key);
        tail = c.prev;
        c.prev = null;
        tail.next = null;
    }

    private Node moveToFront(int key) {
        Node c = h.get(key);

        if (c == head.next) {
            return c;
        }

        Node pre = c.prev;
        Node nxt = c.next;

        Node t = head.next;
        c.next = t;
        head.next = c;
        c.prev = head;
        t.prev = c;

        if (nxt != null) {
            nxt.prev = pre;
        } else {
            tail = pre;
        }

        pre.next = nxt;
        return c;
    }
}
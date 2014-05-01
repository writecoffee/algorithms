import java.util.HashMap;

public class lru_cache_singly_linkedlist {
    private class Node {
        private int val;
        private final int key;
        private Node next;

        private Node(int _key, int _val) {
            val = _val;
            key = _key;
        }

        private void setValue(int newVal) {
            val = newVal;
        }
    }

    private HashMap<Integer, Node> hPrev;
    private Node head, tail;
    private int capacity;

    public lru_cache_singly_linkedlist(int _capacity) {
        capacity = _capacity;
        hPrev = new HashMap<Integer, Node>(_capacity, 1.0f);
        head = new Node(-1, -1);
        tail = head;
    }

    /**
     * (1) Note that when the target is the "latest" used element, there is no need to call
     *     this function to move it to the "head"; just an edge case need to be considered.
     * 
     * (2) Also note that if "c == tail", "c.next" is null.
     * 
     */
    private Node moveToHead(int key) {
        Node pre = hPrev.get(key);
        assert pre != head;
        Node c = pre.next;

        if (c == tail) {
            hPrev.put(key, head);
            hPrev.put(head.next.key, c);
            tail = pre;
        } else {
            hPrev.put(key, head);
            hPrev.put(head.next.key, c);
            hPrev.put(c.next.key, pre);
        }

        Node t = head.next;
        head.next = c;
        pre.next = c.next;
        c.next = t;
        return c;
    }

    public int get(int key) {
        if (!hPrev.containsKey(key)) {
            return -1;
        } else if (hPrev.get(key) == head) {
            return head.next.val;
        } else {
            return moveToHead(key).val;
        }
    }

    public void set(int key, int value) {
        if (hPrev.containsKey(key) && hPrev.get(key) == head) {
            head.next.setValue(value);
        } else if (hPrev.containsKey(key)) {
            moveToHead(key).setValue(value);
        } else {
            if (hPrev.size() == capacity) {
                tail = hPrev.get(tail.key);
                hPrev.remove(tail.next.key);
                tail.next = null;
            }

            Node c = new Node(key, value);
            tail.next = c;
            hPrev.put(key, tail);
            tail = c;

            if (head.next != tail) {
                moveToHead(key);
            }
        }
    }
}
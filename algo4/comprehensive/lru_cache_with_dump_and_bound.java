import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Your cache should store simple key/value strings of length up to 10 characters.
 * It should also have a customizable upper bound to the number of keys that can
 * be stored in the cache at any time. You do not have to be thread safe.
 *
 * Possible Inputs:
 *
 * BOUND: Set the upper bound. If the cache size is currently greater than this
 *        number, then extra entries must be removed following the LRU policy
 *
 * SET:   Set the value of this key
 *
 * GET:   Get the value of this key and prints to stdout.
 *
 * PEEK:  Gets the value of the key but does not mark it as being used. Prints the
 *        value to standard out.
 *
 * DUMP:  Prints the current state of the cache as a list of key/value pairs in
 *        alphabetical order by key.
 *
 *
 * Input Format:
 *
 * First line of input contains an integer N,the number of commands. The following
 * N lines each describe a command. Note: The first command will always be BOUND.
 *
 *
 * Output Format:
 *
 * Print the appropriate outputs for GET , PEEK and DUMP commands. In case for GET
 * /PEEK command if the key does not exist in the cache just output the string "NULL"
 * (quotes are for clarity).
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://box.interviewstreet.com/challenges/dashboard/#problem/4f3c42a47d165}
 *
 */
public class lru_cache_with_dump_and_bound {
    public static class LRUCache<K extends Comparable<K>, V> {
        private class Node<K1 extends Comparable<K1>, V1> implements Comparable<Node<K1, V1>> {
            private V1 val;
            private final K1 key;
            private Node<K1, V1> next;
            private Node<K1, V1> prev;

            private Node(K1 _key, V1 _val) {
                val = _val;
                key = _key;
            }

            @Override
            public int compareTo(Node<K1, V1> o) {
                return key.compareTo(o.key);
            }
        }

        private int capacity;
        private final V notFound;
        private TreeMap<K, Node<K, V>> h;
        private Node<K, V> head, tail;

        public LRUCache(int _capacity, V _notFound) {
            capacity = _capacity;
            notFound = _notFound;
            h = new TreeMap<K, Node<K, V>>();
            head = new Node<K, V>(null, null);
            tail = head;
        }

        public V get(K key) {
            Node<K, V> node = h.get(key);
            return node == null ? notFound : moveToFront(node).val;
        }

        public V peek(K key) {
            Node<K, V> node = h.get(key);
            return node == null ? notFound : node.val;
        }

        public void set(K key, V value) {
            if (h.containsKey(key)) {
                moveToFront(h.get(key)).val = value;
            } else {
                if (h.size() == capacity) {
                    removeTail();
                }

                Node<K, V> c = new Node<K, V>(key, value);
                tail.next = c;
                c.prev = tail;
                tail = c;
                h.put(key, c);
                moveToFront(c);
            }
        }

        public String dump() {
            StringBuilder sb = new StringBuilder();

            for (Entry<K, Node<K, V>> entry : h.entrySet()) {
                sb.append(entry.getKey());
                sb.append(" ");
                sb.append(entry.getValue().val);
                sb.append("\n");
            }

            return sb.toString();
        }

        public void bound(int newBound) {
            int cSize = h.size();

            for (int i = 0; i < cSize - newBound; ++i) {
                removeTail();
            }

            capacity = newBound;
        }

        private void removeTail() {
            Node<K, V> c = h.remove(tail.key);
            tail = c.prev;
            c.prev = null;
            tail.next = null;
        }

        private Node<K, V> moveToFront(Node<K, V> c) {
            if (c == head.next) {
                return c;
            }

            Node<K, V> pre = c.prev;
            Node<K, V> nxt = c.next;

            Node<K, V> t = head.next;
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

    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int n = Integer.parseInt(in.readLine());
        LRUCache<String, String> instance = new LRUCache<String, String>(Integer.parseInt(in.readLine().split("\\s+")[1]), "NULL");

        for (int i = 1; i < n; ++i) {
            String[] splits = in.readLine().split("\\s+");

            if (splits[0].equals("BOUND")) {
                instance.bound(Integer.parseInt(splits[1]));
            } else if (splits[0].equals("SET")) {
                instance.set(splits[1], splits[2]);
            } else if (splits[0].equals("GET")) {
                out.println(instance.get(splits[1]));
            } else if (splits[0].equals("PEEK")) {
                out.println(instance.peek(splits[1]));
            } else if (splits[0].equals("DUMP")) {
                out.print(instance.dump());
            }
        }

        in.close();
        out.close();
    }
}
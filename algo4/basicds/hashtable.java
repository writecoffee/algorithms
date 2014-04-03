import java.util.Map;

public class hashtable<K, V> {
    private Entry<K, V>[] table;
    private int size;
    private int capacity;
    static final int DEFAULT_INITIAL_CAPACITY = 16;

    public hashtable(int _capacity) {
        capacity = _capacity;
        table = new Entry[_capacity];
        size = 0;
    }

    public hashtable() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public int size() {
        return size;
    }

    private int hash(K key) {
        return key.hashCode() % capacity;
    }

    void addEntry(int hash, K key, V value) {
        Entry<K, V> e = table[hash];
        table[hash] = new Entry<K, V>(key, value, e);
    }

    public V get(K key) {
        if (key == null) {
            return getForNullKey();
        }

        for (Entry<K, V> e = table[hash(key)]; e != null; e = e.next) {
            K k;
            if ((k = e.key) == key || key.equals(k)) {
                return e.value;
            }
        }

        return null;
    }

    public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);
        }

        int hash = hash(key);
        for (Entry<K, V> e = table[hash]; e != null; e = e.next) {
            K k = e.key;
            if (k == key || key.equals(k)) {
                return e.setValue(value);
            }
        }

        addEntry(hash, key, value);
        return null;
    }

    private V putForNullKey(V value) {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }

        addEntry(0, null, value);
        return null;
    }

    private V getForNullKey() {
        for (Entry<K, V> e = table[0]; e != null; e = e.next) {
            if (e.key == null)
                return e.value;
        }

        return null;
    }

    private class Entry<M, L> implements Map.Entry<M, L> {
        private final M key;
        private L value;
        private Entry<M, L> next;

        private Entry(M k, L v, Entry<M, L> n) {
            value = v;
            next = n;
            key = k;
        }

        @Override
        public M getKey() {
            return key;
        }

        @Override
        public L getValue() {
            return value;
        }

        @Override
        public L setValue(L newValue) {
            L oldValue = value;
            value = newValue;
            return oldValue;
        }

        /**
         * This ensures that e1.equals(e2) implies that e1.hashCode()==e2.hashCode() for any
         * two Entries e1 and e2, as required by the general contract of Object.hashCode.
         */
        public final int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
        }
    }
}
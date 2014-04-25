import java.util.Map;

public class hashtable<K, V> {
    private Entry<K, V>[] table;
    private int count;
    private float loadFactor;
    private int threshold;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public hashtable(int _capacity) {
        table = new Entry[_capacity];
        loadFactor = .75f;
        threshold = (int) (_capacity * loadFactor);
        count = 0;
    }

    public hashtable() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public int size() {
        return count;
    }

    private int hashToBucket(K key) {
        return key.hashCode() % table.length;
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException();
        }

        for (Entry<K, V> e = table[hashToBucket(key)]; e != null; e = e.next) {
            K k;
            if ((k = e.key) == key || key.equals(k)) {
                return e.value;
            }
        }

        return null;
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException();
        }

        int index = hashToBucket(key);
        for (Entry<K, V> e = table[index]; e != null; e = e.next) {
            K k = e.key;
            if (k == key || key.equals(k)) {
                return e.setValue(value);
            }
        }

        count++;
        if (count >= threshold) {
            rehash();
            index = hashToBucket(key);
        }

        Entry<K, V> e = table[index];
        table[index] = new Entry<K, V>(key, value, e);
        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Unsupported");
        }

        int index = hashToBucket(key);
        for (Entry<K, V> e = table[index], prev = null; e != null; prev = e, e = e.next) {
            if ((e.key.hashCode() == key.hashCode()) && e.key.equals(key)) {
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    table[index] = e.next;
                }

                count--;
                V oldValue = e.value;
                e.value = null;
                return oldValue;
            }
        }

        return null;
    }

    private void rehash() {
        int newCapacity = (table.length << 1) + 1;
        int oldCapacity = table.length;
        @SuppressWarnings("unchecked")
        Entry<K, V>[] newMap = new Entry[newCapacity];
        Entry<K, V>[] oldMap = table;
        threshold = (int) (newCapacity * loadFactor);
        table = newMap;

        for (int i = oldCapacity - 1; i >= 0; --i) {
            for (Entry<K, V> old = oldMap[i]; old != null;) {
                Entry<K, V> e = old;
                // move to the next entry first
                old = old.next;
                int index = hashToBucket(old.key);
                e.next = newMap[index];
                newMap[index] = e;
            }
        }
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
    }
}
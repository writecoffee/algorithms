import java.util.Iterator;
import java.util.NoSuchElementException;

public class circular_array<T> implements Iterable<T> {
    private T[] items;
    private int head = 0;

    @SuppressWarnings("unchecked")
    public circular_array(int _size) {
        items = (T[]) new Object[_size];
    }

    private int convert(int offset) {
        if (offset < 0) {
            offset += items.length;
        }

        return (head + offset) % items.length;
    }

    public void rotate(int offset) {
        head = convert(offset);
    }

    public T get(int i) {
        if (i < 0 || i >= items.length) {
            throw new IndexOutOfBoundsException();
        }

        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    public Iterator<T> iterator() {
        return new CircularArrayIterator<T>(this);
    }

    private class CircularArrayIterator<TI> implements Iterator<TI> {
        private int current = -1;
        private TI[] items;

        public CircularArrayIterator(circular_array<TI> array) {
            items = array.items;
        }

        @Override
        public boolean hasNext() {
            return current < items.length - 1;
        }

        @Override
        public TI next() {
            if (current == items.length - 1) {
                throw new NoSuchElementException("Reach the end of the circurlar array");
            }

            TI item = (TI) items[convert(++current)];
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
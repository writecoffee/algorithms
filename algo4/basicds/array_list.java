import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class array_list<T> {
    private Object[] elements;
    private int size = 0;
    private int capacity;
    private int modCount = 0;
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public array_list(int _capacity) {
        if (_capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + _capacity);
        }

        elements = new Object[_capacity];
        size = 0;
        capacity = _capacity;
    }

    public array_list() {
        elements = EMPTY_ELEMENTDATA;
        size = 0;
        capacity = 0;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return (T) elements[index];
    }

    public void add(Object object) {
        if (size == capacity) {
            expandCapacity();
        }

        elements[size++] = object;
    }

    private void expandCapacity() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        Object removed = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[size--] = null;
        return (T) removed;
    }

    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {
        int i;
        int lastRet = -1;
        int expectedModCount = modCount;

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            checkForComodification();
            if (i >= size) {
                throw new NoSuchElementException();
            }

            if (i >= elements.length) {
                throw new ConcurrentModificationException();
            }

            lastRet = i++;
            return (T) elements[lastRet];
        }

        private void checkForComodification() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public boolean hasNext() {
            return i != size;
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            checkForComodification();

            try {
                array_list.this.remove(lastRet);
                i = lastRet;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
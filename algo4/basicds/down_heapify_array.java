public class down_heapify_array {
    public static class Heap {
        public int[] values;

        Heap(int[] _values) {
            values = _values;
        }

        void update(int[] _values) {
            values = _values;
        }
    }

    public static int pop(Heap heap) {
        int[] values = heap.values;
        assert values.length > 0;

        int result = values[0];
        int[] newValues = new int[values.length - 1];
        for (int i = 1; i < values.length - 1; i++) {
            newValues[i] = values[i];
        }
        newValues[0] = values[values.length - 1];

        downHeapify(newValues, 0);
        heap.update(newValues);

        return result;
    }

    private static void downHeapify(int[] values, int i) {
        if (leaf(values, i)) {
            return;
        } else if (oneChild(values, i)) {
            if (values[i] > values[left(i)]) {
                swap(values, i, left(i));
            }
        } else {
            if (Math.min(values[left(i)], values[right(i)]) >= values[i]) {
                return;
            } else {
                if (values[left(i)] < values[right(i)]) {
                    swap(values, i, left(i));
                    downHeapify(values, left(i));
                } else {
                    swap(values, i, right(i));
                    downHeapify(values, right(i));
                }
            }
        }
    }

    private static int right(int i) {
        return i * 2 + 2;
    }

    private static int left(int i) {
        return i * 2 + 1;
    }

    private static boolean oneChild(int[] values, int i) {
        return right(i) == values.length;
    }

    private static boolean leaf(int[] values, int i) {
        return left(i) >= values.length && right(i) >= values.length;
    }

    private static void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new int[] { 2, 4, 3, 5, 9, 7, 7 });

        pop(heap);
        assert 3 == heap.values[0];
        pop(heap);
        assert 4 == heap.values[0];
    }
}
import java.util.ArrayList;

public class min_heap {
    private ArrayList<Integer> values;

    public min_heap(int[] _values) {
        values = new ArrayList<Integer>();

        for (int i = 0; i < _values.length; ++i) {
            values.add(_values[i]);
            upHeapitfy();
        }
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public int peek() {
        return values.get(0);
    }

    public int popMin() {
        int result = values.get(0);

        if (values.size() > 1) {
            values.set(0, values.remove(values.size() - 1));
            downHeapify();
        } else {
            values.clear();
        }

        return result;
    }

    private void downHeapify() {
        for (int i = 0; !isLeaf(i);) {
            if (hasOneChild(i)) {
                if (values.get(i) > values.get(getLeft(i))) {
                    swap(i, getLeft(i));
                    i = getLeft(i);
                } else {
                    break;
                }
            } else {
                if (values.get(i) <= Math.min(values.get(getLeft(i)), values.get(getRight(i)))) {
                    break;
                } else if (values.get(getLeft(i)) < values.get(getRight(i))) {
                    swap(i, getLeft(i));
                    i = getLeft(i);
                } else {
                    swap(i, getRight(i));
                    i = getRight(i);
                }
            }
        }
    }

    private void upHeapitfy() {
        for (int i = values.size() - 1; i > 0 && values.get(getParent(i)) > values.get(i); i = getParent(i)) {
            swap(i, getParent(i));
        }
    }

    private boolean hasOneChild(int i) {
        return getRight(i) >= values.size();
    }

    private boolean isLeaf(int i) {
        return getLeft(i) >= values.size();
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getRight(int i) {
        return i * 2 + 2;
    }

    private int getLeft(int i) {
        return i * 2 + 1;
    }

    private void swap(int i, int j) {
        int t = values.get(i);
        values.set(i, values.get(j));
        values.set(j, t);
    }

    public static void main(String[] args) {
        min_heap heap = new min_heap(new int[] { 7, 1, 2, 4, 3, 5, 9, 7, 7, 8 });
        assert heap.popMin() == 1;
        assert heap.popMin() == 2;
        assert heap.popMin() == 3;
        assert heap.popMin() == 4;
        assert heap.popMin() == 5;
        assert heap.popMin() == 7;
        assert heap.popMin() == 7;
        assert heap.popMin() == 7;
        assert heap.popMin() == 8;
        assert heap.popMin() == 9;
    }
}
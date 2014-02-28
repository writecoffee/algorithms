public class up_heapify_array {
    public static void upHeapify(int[] values) {
        assert values.length > 0;

        int s = values.length - 1;

        while (s != 0) {
            if (values[s] < values[parent(s)]) {
                swap(values, s, parent(s));
                s = parent(s);
            } else {
                break;
            }
        }
    }

    private static void swap(int[] values, int i, int j) {
        assert i >= 0 && i < values.length;
        assert j >= 0 && j < values.length;

        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    private static int parent(int s) {
        return (s - 1) / 2;
    }

    public static void main(String[] args) {
        int[] values = new int[] { 2, 4, 3, 5, 9, 7, 7, 1 };

        upHeapify(values);

        assert 1 == values[0];
        assert 2 == values[1];
    }
}
public class sort_three_colors {
    private final static int RED = 0;
    private final static int WHITE = 1;
    private final static int BLUE = 2;

    public void sortColors(int[] array) {
        int n = array.length;
        int l = -1, r = n, i = 0;

        while (i < r) {
            switch (array[i]) {
            case RED:
                swap(++l, i++, array);
                break;
            case WHITE:
                ++i;
                break;
            case BLUE:
                swap(i, --r, array);
                break;
            default:
                break;
            }
        }
    }

    private void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
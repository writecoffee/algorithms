public class sort_colors {

    public final static int RED = 0;
    public final static int WHITE = 1;
    public final static int BLUE = 2;

    public static void sortColors(int[] A) {
        int redStart = -1;
        int blueStart = A.length;
        int i = 0;

        while (i < blueStart) {
            switch (A[i]) {
            case RED:
                swap(i++, ++redStart, A);
                break;
            case WHITE:
                i++;
                break;
            case BLUE:
                swap(i, --blueStart, A);
                break;
            default:
                throw new IllegalArgumentException();
            }
        }
    }

    private static void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        sortColors(new int[] { BLUE, RED, WHITE, WHITE, BLUE });
    }
}
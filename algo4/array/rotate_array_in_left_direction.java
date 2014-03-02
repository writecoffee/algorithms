public class rotate_array_in_left_direction {
    public static int[] rotate(int[] array, int k) {
        k = k % array.length;

        for (int i = 0; i < k; i++) {
            int temp = array[i];
            int j = i + 1;

            while (j != i) {
                array[(array.length + j - 1) % array.length] = array[j];
                j = (j + 1) % array.length;
            }

            array[(array.length + j - 1) % array.length] = temp;
        }

        return array;
    }

    public static int[] rotateOpt(int[] array, int k) {
        k = k % array.length;

        for (int i = 0; i < gcd(array.length, k); i++) {
            int temp = array[i];
            int j = i + k;

            while (j != i) {
                array[(array.length + j - k) % array.length] = array[j];
                j = (j + k) % array.length;
            }

            array[(array.length + j - k) % array.length] = temp;
        }

        return array;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        rotateOpt(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 10);
    }
}
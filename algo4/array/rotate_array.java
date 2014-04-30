public class rotate_array {
    public int[] rotateRedundant(int[] array, int k) {
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

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public void rotate(int[] array, int d) {
        if (array.length == 0) {
            return;
        }

        while (d < 0) {
            d += array.length;
        }

        int n = array.length;
        d %= n;
        int i = d;
        int pre = array[0];

        while (i != 0) {
            int t = array[i];
            array[i] = pre;
            i = (i + d) % n;
            pre = t;
        }

        array[0] = pre;
    }
}
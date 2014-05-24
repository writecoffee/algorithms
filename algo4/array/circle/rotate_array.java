package circle;

public class rotate_array {
    /**
     * Notice that if the n and k has non-1 common divisor, if would juggle
     * back to the starting position for one pass. So we should find the 
     * greatest common divisor for n and k.
     * 
     */
    public void rotateOnepass(int[] array, int k) {
        int n = array.length;

        while (k < 0) {
            k += n;
        }

        k = k % n;

        for (int i = 0; i < gcd(array.length, k); i++) {
            int hold = array[(i + k) % n];
            array[(i + k) % n] = array[i];

            for (int j = (i + k) % n; j != i; j = (j + k) % n) {
                int t = array[(j + k) % n];
                array[(j + k) % n] = hold;
                hold = t;
            }
        }
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public void rotate(int[] array, int k) {
        int n = array.length;

        while (k < 0) {
            k += n;
        }

        k %= n;

        reverse(array, 0, n - 1);
        reverse(array, 0, k - 1);
        reverse(array, k, n - 1);
    }

    private void reverse(int[] array, int l, int r) {
        while (l < r) {
            int t = array[l];
            array[l] = array[r];
            array[r] = t;
            l++;
            r--;
        }
    }
}
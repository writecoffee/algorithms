public class next_permutation {
    private void swap(int[] num, int a, int b) {
        num[a] ^= num[b];
        num[b] ^= num[a];
        num[a] ^= num[b];
    }

    private void reverse(int[] num, int l, int r) {
        while (l < r) {
            swap(num, l++, r--);
        }
    }

    public void nextPermutation(int[] num) {
        int n = num.length, i = n - 1;
        while (i >= 1 && num[i] <= num[i - 1]) {
            i--;
        }

        reverse(num, i, n - 1);
        if (i > 0) {
            int j = i;
            while (j < n && num[j] <= num[i - 1]) {
                j++;
            }
            swap(num, i - 1, j);
        }
    }
}
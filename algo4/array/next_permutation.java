public class next_permutation {
    private static void swap(int[] num, int a, int b) {
        num[a] ^= num[b];
        num[b] ^= num[a];
        num[a] ^= num[b];
    }

    private static void reverse(int[] num, int l, int r) {
        while (l < r) {
            swap(num, l++, r--);
        }
    }

    public static void nextPermutation(int[] num) {
        int i = num.length - 1;
        while (i > 0 && num[i - 1] >= num[i]) {
            --i;
        }

        reverse(num, i, num.length - 1);
        if (i > 0) {
            int next = i;
            i -= 1;
            while (num[next] <= num[i]) {
                ++next;
            }

            swap(num, next, i);
        }
    }

    public boolean hasNextPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 1;

        if (n < 1) {
            return false;
        }

        while (i >= 1 && arr[i] <= arr[i - 1]) {
            --i;
        }

        reverse(arr, i, n);

        if (i > 0) {
            int next = i;
            i--;
            while (arr[next] <= arr[i]) {
                next++;
            }

            swap(arr, i, next);
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[] { 0, 2, 1 };
        nextPermutation(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]);
        }
    }
}
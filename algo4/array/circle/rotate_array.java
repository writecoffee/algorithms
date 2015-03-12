package circle;

/**
 * Write a function rotate(array[], d, n) that rotates array[] of size n by d elements.
 *
 *  +---------------------------------+
 *  |  1  2  3  4  5  6  7  8  9  10  |
 *  +---------------------------------+
 *
 * Rotation of the above array by 2 will make array
 *
 *  +---------------------------------+
 *  |  9  10  1  2  3  4  5  6  7  8  |
 *  +---------------------------------+
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://www.geeksforgeeks.org/array-rotation/}
 *                {@linkplain https://leetcode.com/problems/rotate-array/}
 *
 */
public class rotate_array {
    /**
     * <p> This most cumbersome way to do it is to rotate the array k times
     * and each round shift the element by one position. However that
     * requires rotating each element k times and O(n * k) time complexity. </p>
     *
     * <p> So how about just to rotate each element to its destination slot
     * with one stride. However, there would be contradictory example (n = 12, k = 8)
     * which will lead to rotation mess-up because we are treating the whole array
     * as one group/region. So the walk-around is to partition the array based on GCD
     * of n and k and thus we can make sure it will not introduce overlapping. </p>
     *
     */
    public void rotateOnepass(int[] nums, int k) {
        int n = nums.length,
            groups = gcd(n, k),
            groupMembers = n / groups;

        k = k % n;

        for (int i = 0; i < groups; ++i) {
            int t1 = nums[i];

            for (int j = 1; j < groupMembers; ++j) {
                int nextIndex = (i + j * k) % n;
                int t2 = nums[nextIndex];
                nums[nextIndex] = t1;
                t1 = t2;
            }

            nums[i] = t1;
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

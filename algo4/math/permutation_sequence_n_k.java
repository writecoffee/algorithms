/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, We get the
 * following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 *
 * [Source]     - {@linkplain https://leetcode.com/problems/permutation-sequence/}
 * [Difficulty] - Medium
 *
 */
public class permutation_sequence_n_k
{
    /**
     * We have (n * (n - 1) * (n - 2) * ... * 1) number of permutations.
     *
     * Starting off from position 0 to n - 1 (0-based iteration) to fill in our output string,
     * we can figure out we can generate (n * (n - 1) * (n - 2) * .. * 1) to (1) number of
     * permutation off the current position.
     *
     * Here k can be used as a dividend. So k over the NEXT position's number of options,
     * we get the quotient, which will be the CURRENT position's number.
     *
     */
    public String getPermutation(int n, int k)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder nums = new StringBuilder("123456789");

        assert n >= 1 && n <= 9;

        int[] f = new int[] { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

        /*
         * k should be 0-based.
         */
        k--;
        for (int i = n; i >= 1; i--) {
            int j = k / f[i - 1];
            k %= f[i - 1];

            char num = nums.charAt(j);
            result.append(num);
            nums.delete(j, j + 1);
        }

        return result.toString();
    }
}

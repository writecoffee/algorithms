package window;

/**
 * Give you an integer array (index from 0 to n-1, where n is the size of this
 * array)，find the longest increasing continuous subsequence in this array. (The
 * definition of the longest increasing continuous subsequence here can be from
 * right to left or from left to right)
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.
 *
 * For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.
 *
 * Note
 *
 * O(n) time and O(1) extra space.
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence/}
 * [Difficulty] - Easy
 *
 */
public class tp_longest_increasing_continuous_subsequences_I
{
    public int longestIncreasingContinuousSubsequence(int[] array)
    {
        int n = array.length;
        int result = 0;

        for (int i = 0, j = 0; i < n; i = j) {
            for (; j < n && (j == i || array[j] > array[j - 1]); j++) {
            }

            result = Math.max(result, j - i);
        }

        for (int i = n - 1, j = n - 1; i >= 0; i = j) {
            for (; j >= 0 && (j == i || array[j] > array[j + 1]); j--) {
            }

            result = Math.max(result, i - j);
            i = j;
        }

        return result;
    }
}

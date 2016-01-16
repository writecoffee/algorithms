package partitioning;

/**
 * Given an array A of integer with size of n( means n books and number of pages
 * of each book) and k people to copy the book. You must distribute the
 * continuous id books to one people to copy. (You can give book A[1],A[2] to
 * one people, but you cannot give book A[1], A[3] to one people, because book
 * A[1] and A[3] is not continuous.) Each person have can copy one page per
 * minute. Return the number of smallest minutes need to copy all the books.
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * Given array A = [3,2,4], k = 2.
 *
 * Return 5( First person spends 5 minutes to copy book 1 and book 2 and second
 * person spends 4 minutes to copy book 3. )
 *
 * Challenge
 *
 * Could you do this in O(n*k) time ?
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/copy-books/}
 * [Difficulty] - hard
 *
 */
public class dp_pt_copy_books
{
    public int compute(int[] pages, int k)
    {
        int n = pages.length;

        /*
         * Ensure that we cannot split books for over 1 person.
         */
        if (k >= n) {
            int maxPage = 0;
            for (int page : pages) {
                maxPage = Math.max(maxPage, page);
            }

            return maxPage;
        }

        int[] bkSingle = new int[n + 1];
        int[][] f = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            bkSingle[i] = pages[i - 1] + bkSingle[i - 1];
            f[i][1] = bkSingle[i];
        }

        /*
         * We start off from 2 person because in the innermost for-loop,
         * we don't want to split the books that is reserved for single
         * person (when nk == 1).
         *
         */
        for (int nk = 2; nk <= k; nk++) {
            for (int i = nk; i <= n; i++) {
                f[i][nk] = Integer.MAX_VALUE;

                for (int j = 0; j < i; j++) {
                    f[i][nk] = Math.min(f[i][nk], Math.max(f[j][nk - 1], bkSingle[i] - bkSingle[j]));
                }
            }
        }

        return f[n][k];
    }
}

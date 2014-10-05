/**
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * "A scientist has index h if h of his/her N papers have at least h citations
 * each, and the other N − h papers have no more than h citations each."
 *
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher
 * has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations
 * respectively. Since the researcher has 3 papers with at least 3 citations
 * each and the remaining two with no more than 3 citations each, his h-index is
 * 3.
 *
 * Note: If there are several possible values for h, the maximum one is taken as
 * the h-index.
 *
 * Hint:
 *
 * 1. An easy approach is to sort the array first.
 *
 * 2. What are the possible values of h-index?
 *
 * 3. A faster approach is to use extra space.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/h-index-i/}
 *
 */
public class h_index
{
    public int hIndex(int[] citations)
    {
        int n = citations.length;
        int[] indexCounter = new int[n + 1];

        for (int cite : citations) {
            indexCounter[Math.min(n, cite)]++;
        }

        for (int i = n - 1; i > 0; i--) {
            indexCounter[i] += indexCounter[i + 1];
        }

        for (int i = n; i > 0; i--) {
            if (indexCounter[i] >= i) {
                return i;
            }
        }

        return 0;
    }
}

/**
 * Given an array of citations (each citation is a non-negative integer) of a
 * researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia:
 * 
 * "A scientist has index h if h of his/her N papers have at least h citations each,
 * and the other N − h papers have no more than h citations each."
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
 * An easy approach is to sort the array first.
 *
 * What are the possible values of h-index?
 *
 * A faster approach is to use extra space.
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 *  Could you optimize your algorithm?
 *
 * Hint:
 *
 * Expected runtime complexity is in O(log n) and the input is sorted.
 *
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/h-index-ii/}
 *
 */
public class bs_h_index_II
{
    public int hIndex(int[] citations)
    {
        int n = citations.length;
        int l = 0, r = n - 1;

        if (n == 0) {
            return 0;
        }

        while (l <= r) {
            int mid = (l + r) / 2,
                midCite = citations[mid];

            if (midCite >= n - mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return n - l;
    }
}

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the
 * very left of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 *
 * For example,
 *
 * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 * Note:
 *
 * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/sliding-window-maximum/}
 * [Tag]        - $double-ended-queue$, $histogram$
 *
 */
public class sliding_window_maximum
{
    /**
     * Create a principal that we maintain a descending order window (size <= k) where
     * the first element of the window is the answer, for RESULT[i - k].
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;

        if (n == 0) {
            return new int[0];
        }

        int[] result = new int[n - k + 1];
        Deque<Integer> pq = new LinkedList<>();

        for (int i = 0; i < n; ++i) {
            int c = nums[i];

            if (i >= k && pq.getLast() == nums[i - k]) {
                pq.removeLast();
            }

            while (!pq.isEmpty() && pq.peekFirst() < c) {
                pq.removeFirst();
            }

            pq.addFirst(c);
            if (i + 1 >= k) {
                result[i - k + 1] = pq.getLast();
            }
        }

        return result;
    }
}

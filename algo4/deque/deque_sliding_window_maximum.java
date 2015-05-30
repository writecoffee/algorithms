package deque;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of n integer with duplicate number, and a moving window(size
 * k), move the window at each iteration from the start of the array, find the
 * maximum number inside the window at each moving.
 *
 * Have you met this question in a real interview? Yes
 *
 * Example
 *
 * For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8]
 *
 * At first the window is at the start of the array like this
 *
 * [|1, 2, 7| ,7, 8] , return the maximum 7;
 *
 * then the window move one step forward.
 *
 * [1, |2, 7 ,7|, 8], return the maximum 7;
 *
 * then the window move one step forward again.
 *
 * [1, 2, |7, 7, 8|], return the maximum 8;
 *
 * Challenge o(n) time and O(k) memory
 *
 * [Source]     - {@linkplain http://www.lintcode.com/en/problem/sliding-window-maximum/}
 *                {@linkplain https://leetcode.com/problems/sliding-window-maximum/}
 * [Difficulty] - Medium
 *
 */
public class deque_sliding_window_maximum
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        int n = nums.length;

        if (k == 0 || n < k) {
            return new int[0];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {
            int theNum = nums[i];

            while (!deque.isEmpty() && theNum > deque.getLast()) {
                deque.removeLast();
            }

            if (i >= k && !deque.isEmpty() && deque.getFirst() == nums[i - k]) {
                deque.removeFirst();
            }

            deque.addLast(theNum);

            if (i >= k - 1) {
                result[i - k + 1] = deque.getFirst();
            }
        }

        return result;
    }
}

package deque;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
 * [Difficulty] - Medium
 *
 */
public class deque_sliding_window_maximum
{
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int num = nums[i];

            while (!deque.isEmpty() && num > deque.peekLast()) {
                deque.pollLast();
            }

            deque.offer(num);

            if (i + 1 > k && deque.peekFirst() == nums[i - k]) {
                deque.pollFirst();
            }

            if (i + 1 >= k) {
                result.add(deque.peekFirst());
            }
        }

        return result;
    }
}

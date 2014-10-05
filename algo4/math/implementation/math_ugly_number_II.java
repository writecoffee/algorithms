package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10
 * ugly numbers.
 *
 * Note that 1 is typically treated as an ugly number.
 *
 * Hint:
 *
 * 1. The naive approach is to call isUgly for every number until you reach the nth
 * one. Most numbers are not ugly. Try to focus your effort on generating only
 * the ugly ones.
 *
 * 2. An ugly number must be multiplied by either 2, 3, or 5 from a
 * smaller ugly number.
 *
 * 3. The key is how to maintain the order of the ugly
 * numbers. Try a similar approach of merging from three sorted lists: L1, L2,
 * and L3.
 *
 * 4. Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 *
 * 2, L2 * 3, L3 * 5).
 *
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/ugly-number-ii/}
 *
 */
public class math_ugly_number_II
{
    public int nthUglyNumber(int n)
    {
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        minHeap.offer(1l);

        for (int i = 1; i < n; ++i) {
            long uglyNumber = minHeap.poll();

            if (!minHeap.contains(uglyNumber * 2)) {
                minHeap.offer(uglyNumber * 2);
            }

            if (!minHeap.contains(uglyNumber * 3)) {
                minHeap.offer(uglyNumber * 3);
            }

            if (!minHeap.contains(uglyNumber * 5)) {
                minHeap.offer(uglyNumber * 5);
            }
        }

        return (int) ((long) minHeap.poll());
    }

    public int nthUglyNumberMergeSort(int n)
    {
        List<Integer> buffer = new ArrayList<>();
        int result = 1,
            id2 = 0,
            id3 = 3,
            id5 = 0;

        for (int i = 1; i < n; ++i) {
            buffer.add(result);

            int v2 = 2 * buffer.get(id2),
                v3 = 3 * buffer.get(id3),
                v5 = 5 * buffer.get(id5);

            result = Math.min(Math.min(v3, v5), v2);
            id2 += (result == v2) ? 1 : 0;
            id3 += (result == v3) ? 1 : 0;
            id5 += (result == v5) ? 1 : 0;
        }

        return result;
    }
}

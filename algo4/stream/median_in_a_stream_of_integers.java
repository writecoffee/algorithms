import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Given that integers are read from a data stream. Find median of elements read so for
 * in efficient way. For simplicity assume there are no duplicates.
 *
 * For example, let us consider the stream 5, 15, 1, 3 ...
 *
 * After reading 1st element of stream - 5 -> median - 5
 * After reading 2nd element of stream - 5, 15 -> median - 10
 * After reading 3rd element of stream - 5, 15, 1 -> median - 5
 * After reading 4th element of stream - 5, 15, 1, 3 -> median - 4, so on ...
 *
 * Making it clear, when the input size is odd, we take the middle element of sorted data.
 * If the input size is even, we pick average of middle two elements in sorted stream.
 *
 * Note that output is effective median of integers read from the stream so far. Such an
 * algorithm is called online algorithm. Any algorithm that can guarantee output of i-elements
 * after processing i-th element, is said to be online algorithm.
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/find-median-from-data-stream/}
 *
 */
public class median_in_a_stream_of_integers
{
    public class MedianFinder
    {
        private PriorityQueue<Integer> min = null;
        private PriorityQueue<Integer> max = null;
        private int                    len = 0;

        public MedianFinder()
        {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>(Collections.reverseOrder());
        }

        /**
         * We are going to maintain two invariants:
         * 
         * (1) max heap at most can have only one extra element than the min heap.
         * (2) root of max heap < root of min heap
         * 
         */
        public void addNum(int num)
        {
            if (len % 2 == 0) {
                max.offer(num);

                /*
                 * Special case when original array sizes are equivalent,
                 * we need to ensure max.peek() <= min.peek().
                 * 
                 */
                if (len >= 1 && max.peek() > min.peek()) {
                    min.offer(max.poll());
                    max.offer(min.poll());
                }
            } else {
                max.offer(num);
                min.offer(max.poll());
            }

            len++;
        }

        public double findMedian()
        {
            if (len == 0) {
                throw new NoSuchElementException();
            }

            return (len % 2 == 0) ? ((double) ((max.peek() + min.peek()) / 2.0)) : ((double) max.peek());
        }
    }
}

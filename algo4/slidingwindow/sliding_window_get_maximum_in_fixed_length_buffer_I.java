import java.util.PriorityQueue;

import com.google.common.base.Function;

/**
 * A long array A[] is given to you. There is a sliding window of size w which
 * is moving from the very left of the array to the very right. You can only see
 * the w numbers in the window. Each time the sliding window moves rightwards by
 * one position. Following is an example: The array is [1 3 -1 -3 5 3 6 7], and
 * w is 3.
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
 * Hint: Use Max Heap data structure to maintain in-window data. Need to know the
 * index of each element.
 * 
 * [Difficulty] - Medium
 * [Source]     - {@linkplain http://articles.leetcode.com/2011/01/sliding-window-maximum.html}
 *
 */
public class sliding_window_get_maximum_in_fixed_length_buffer_I {

    private class Wrapper<T extends Comparable<T>> implements Comparable<Wrapper<T>> {
        private final T value_;
        private final int index_;

        private Wrapper(T value, int index) {
            value_ = value;
            index_ = index;
        }

        @Override
        public int compareTo(Wrapper<T> o) {
            return o.value_.compareTo(value_);
        }
    }

    private PriorityQueue<Wrapper<Integer>> pq = new PriorityQueue<Wrapper<Integer>>();

    private int slide(Integer[] buffer, int windowSize, int i) {
        int current = buffer[i];

        while (true) {
            if (i - windowSize <= 0) {
                pq.add(new Wrapper<Integer>(current, i));
                break;
            } else if (pq.peek().index_ <= i - windowSize) {
                pq.poll();
            } else if (pq.peek().value_ < current) {
                pq.add(new Wrapper<Integer>(current, i));
                break;
            } else {
                pq.add(new Wrapper<Integer>(current, i));
                break;
            }
        }

        return pq.peek().value_;
    }

    public void drive(Integer[] buffer, int windowSize, Function<Integer, Void> lambda) {
        for (int i = 0; i < buffer.length; ++i) {
            lambda.apply(slide(buffer, windowSize, i));
        }
    }
}

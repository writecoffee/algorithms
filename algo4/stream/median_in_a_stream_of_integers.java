import java.util.Comparator;
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
 * [Source]     - {@linkplain http://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/}
 *
 */
public class median_in_a_stream_of_integers {
    private PriorityQueue<Integer> r = new PriorityQueue<Integer>();
    private PriorityQueue<Integer> l = new PriorityQueue<Integer>(0, new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    });

    public double calculateMedian(int freshNumber) {
        if (r.isEmpty() || freshNumber >= r.peek()) {
            r.add(freshNumber);

            if (r.size() - l.size() > 1) {
                l.add(r.poll());
                return (l.peek() + r.peek()) / 2;
            } else {
                return r.peek();
            }
        }

        if (l.isEmpty() || freshNumber < l.peek()) {
            l.add(freshNumber);

            if (l.size() > r.size()) {
                r.add(l.poll());
                return r.poll();
            } else {
                return (l.peek() + r.peek()) / 2;
            }
        }

        return 0;
    }
}
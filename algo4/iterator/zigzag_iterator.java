import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 *
 * For example, given two 1d vectors:
 *
 * v1 = [1, 2]
 *
 * v2 = [3, 4, 5, 6]
 *
 * By calling next repeatedly until hasNext returns false, the order of elements returned
 * by next should be: [1, 3, 2, 4, 5, 6].
 *
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/zigzag-iterator/}
 * [Tag]        - $iterator$, $matrix$
 *
 */
public class zigzag_iterator
{
    public class ZigzagIterator
    {
        Deque<List<Integer>> rotations;
        Deque<Integer> indices;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2)
        {
            rotations = new LinkedList<>(Arrays.asList(v1, v2));
            indices = new LinkedList<>(Arrays.asList(0, 0));
        }

        public int next()
        {
            int result = rotations.peekFirst().get(indices.peekFirst());

            rotations.addLast(rotations.pollFirst());
            indices.addLast(indices.pollFirst() + 1);

            return result;
        }

        public boolean hasNext()
        {
            while (!rotations.isEmpty() && rotations.peekFirst().size() == indices.peekFirst()) {
                rotations.pollFirst();
                indices.pollFirst();
            }

            return !rotations.isEmpty();
        }
    }
}

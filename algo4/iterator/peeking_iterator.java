import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design
 * and implement a PeekingIterator that support the peek() operation -- it
 * essentially peek() at the element that will be returned by the next call to
 * next().
 *
 * Here is an example. Assume that the iterator is initialized to the beginning
 * of the list: [1, 2, 3].
 *
 * Call next() gets you 1, the first element in the list.
 *
 * Now you call peek() and it returns 2, the next element. Calling next() after
 * that still return 2.
 *
 * You call next() the final time and it returns 3, the last element. Calling
 * hasNext() after that should return false.
 *
 * Hint:
 *
 * 1. Think of "looking ahead". You want to cache the next element.
 *
 * 2. Is one variable sufficient? Why or why not? Test your design with call
 *    order of peek() before next() vs next() before peek().
 *
 * 3. For a clean implementation, check out Google's guava library source code.
 *
 * Follow up: How would you extend your design to be generic and work with all
 *            types, not just integer?
 *
 * [Difficulty] - Medium
 * [Source]     - {@linkplain https://leetcode.com/problems/peeking-iterator/}
 *
 */
public class peeking_iterator
{
    class PeekingIterator implements Iterator<Integer>
    {
        private Iterator<Integer> it;
        private Integer cache = null;

        public PeekingIterator(Iterator<Integer> iterator) {
            it = iterator;
        }

        // Returns the next element in the iteration without advancing the
        // iterator.
        public Integer peek()
        {
            if (cache != null) {
                return cache;
            }

            if (it.hasNext()) {
                cache = it.next();
            } else {
                cache = null;
            }

            return cache;
        }

        // hasNext() and next() should behave the same as in the Iterator
        // interface.
        // Override them if needed.
        @Override
        public Integer next()
        {
            if (cache != null) {
                Integer result = cache;
                cache = null;
                return result;
            }

            return it.next();
        }

        @Override
        public boolean hasNext()
        {
            return cache != null || it.hasNext();
        }
    }
}

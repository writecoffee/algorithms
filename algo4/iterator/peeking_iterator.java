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
 * 2. Is one variable sufficient? Why or why not? Test your design with call order of peek() before
 * next() vs next() before peek().
 *
 * 3. For a clean implementation, check out Google's guava library source code.
 *
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 *
 * [Difficulty] - Easy
 * [Source]     - {@linkplain https://leetcode.com/problems/peeking-iterator/}
 *
 */
public class peeking_iterator
{
    class PeekingIterator implements Iterator<Integer>
    {
        private Iterator<Integer> core;
        private Integer           peekVal;

        public PeekingIterator(Iterator<Integer> iterator)
        {
            // initialize any member here.
            core = iterator;

            if (iterator.hasNext()) {
                peekVal = core.next();
            }
        }

        // Returns the next element in the iteration without advancing the
        // iterator.
        public Integer peek()
        {
            return peekVal;
        }

        // hasNext() and next() should behave the same as in the Iterator
        // interface.
        // Override them if needed.
        @Override
        public Integer next()
        {
            int result = peekVal;

            if (core.hasNext()) {
                peekVal = core.next();
            } else {
                peekVal = null;
            }

            return result;
        }

        @Override
        public boolean hasNext()
        {
            return peekVal != null || core.hasNext();
        }
    }
}
